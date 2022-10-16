package com.my.project.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.M_Page;
import com.my.project.dto.Member;
import com.my.project.repository.MemberRepository;

@Service
public class  MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
	private MemberRepository memberRepository;
	
	//파일 저장 경로(root-context.xml)
	@Autowired
	private String savedir;
	
	@Autowired
	private FileService fileService; //파일을 업로드
	
	//비밀번호 암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	public Map<String, Object> insert(Member member) {
		//return : 0 정상, 1:중복아이디
		Map<String, Object> rmap = new HashMap();
		
		//1)중복아이디 체크
		Member dbmember = memberRepository.selectOne(member.getMid());
		if (dbmember != null) {
			rmap.put("code", 1);
			rmap.put("msg", "이미 등록된 아이디");
			return rmap;
		}
		
		//2)파일 업로드
		MultipartFile photofile = member.getPhotofile();
		String fname = fileUpload(photofile);
		member.setFilename(fname);
		
		//3)비밀번호 암호화
		String cryptPasswd =  bCryptPasswordEncoder.encode(member.getPasswd());
		member.setPasswd(cryptPasswd);
		
		//4)저장
		int cnt = memberRepository.insert(member);
		
		
		rmap.put("code", 0);
		rmap.put("msg", "저장완료");
		return rmap;
	}
	
	
	//파일 업로드 후 파일이름 리턴
	public String fileUpload(MultipartFile mfile) {
		String fname = mfile.getOriginalFilename(); //파일이름 읽기
		fname = System.currentTimeMillis() +"_" +fname;
		//파일이름이 없다면 return
		if(fname.equals("")) return"";
		
		try {
			File file = new File(savedir, fname);	
			mfile.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return fname;
	}


	@Override
	public ErrorCode mupdate(Member member) throws Exception {
		MultipartFile photofile = member.getPhotofile();
		String filename = fileService.fileUpload(photofile);
		if (!filename.equals("")) member.setFilename(filename);
		
		
		memberRepository.mupdate(member);
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	@Override
	public ErrorCode update(Member member) throws Exception {
		MultipartFile photofile = member.getPhotofile();
		String filename = fileService.fileUpload(photofile);
		if (!filename.equals("")) member.setFilename(filename);
		
		
		memberRepository.update(member);
		return ErrorCode.SUCCESS_MODIFY;
	}

	@Override
	public ErrorCode pwupdate(Member member, String oldPasswd, String newPasswd) {
		
		Member dbmember = memberRepository.selectOne(member.getMid());

		//1)기존 비밀번호
		//평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(oldPasswd, dbmember.getPasswd());
		if (!match) {
			return ErrorCode.ERROR_LOGIN_PASSWD;
		}
		
		String cryptPasswd; 
		if (!newPasswd.equals("")) 
			cryptPasswd =  bCryptPasswordEncoder.encode(newPasswd);
		else  //기존 비밀번호 암호화
			cryptPasswd =  bCryptPasswordEncoder.encode(member.getPasswd());
		
		member.setPasswd(cryptPasswd);
		
		memberRepository.pwupdate(member);
		return ErrorCode.SUCCESS_MODIFY;
	}





	@Override
	public List<Member> selectList(M_Page m_page) {
		int curPage = m_page.getCurPage(); //현재페이지
		int perPage = m_page.getPerPage(); //한페이지당 게시물수
		int perBlock = m_page.getPerBlock(); //페이지 블럭의 수
		int startNum = (curPage-1) * perPage;
		int endNum = startNum + perPage -1;
		int totalCnt = memberRepository.selectTotalCnt(m_page);
		int totPage = totalCnt/perPage;
		if (totalCnt%perPage!=0) totPage++;
		int startPage= curPage - ((curPage-1)%perBlock);
		int endPage = startPage + perBlock - 1;
		if (endPage>totPage) endPage=totPage;
		
		m_page.setStartNum(startNum);
		m_page.setEndNum(endNum);
		m_page.setStartPage(startPage);
		m_page.setEndPage(endPage);
		m_page.setTotPage(totPage);
	
		return memberRepository.selectList(m_page);
	}





	@Override
	public Member selectOne(String mid) {
		
		return memberRepository.selectOne(mid);
	}


	@Override
	public ErrorCode delete(String mid, HttpSession session) {
		String mcode = (String) session.getAttribute("mcode");
		if(mcode.equals("0")) {
			memberRepository.delete(mid);
			return ErrorCode.SUCCESS_REMOVE;
		}else {
			return ErrorCode.ERROR_ACCESS_DENIED;
		}
	}

}


