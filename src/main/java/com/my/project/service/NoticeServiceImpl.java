package com.my.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.Notice;
import com.my.project.dto.NoticeFile;
import com.my.project.repository.NoticeFileRepository;
import com.my.project.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	@Autowired
	private NoticeFileRepository noticeFileRepository; 
	@Autowired
	private FileService fileService;
	
	@Override
	public List<Notice> selectList() {
		return noticeRepository.selectList();
	}

	@Override
	public Notice selectOne(int nnum) {
		return noticeRepository.selectOne(nnum);
	}

	//트랜잭션 관리(commit,rollback)
	@Transactional
	@Override
	public ErrorCode insert(Notice notice) throws Exception {
		//1)게시물 추가
		//insert시 bnum세팅
		noticeRepository.insert(notice);
		System.out.println(notice);
		
		//2)게시물 파일들 업로드 후 저장
		noticeFilesSave(notice);
		
		return ErrorCode.SUCCESS_ADD;
		
	}

	@Override
	public int updateReadCnt(int nnum) {
		// TODO Auto-generated method stub
		return noticeRepository.updateReadCnt(nnum);
	}
	
	//트랜잭션 관리
	@Transactional
	@Override
	public ErrorCode update(Notice notice, List<Integer> removeFiles) throws Exception {
		//1) 게시물수정
		noticeRepository.update(notice);
		//2) 게시물파일 db 삭제
		if (removeFiles!= null) {
			for(int nfnum : removeFiles) {
				noticeFileRepository.delete(nfnum);
			}
		}
		//3)게시물 파일들 업로드 후 저장
		noticeFilesSave(notice);
		
		return ErrorCode.SUCCESS_MODIFY;
	}
	
	private void noticeFilesSave(Notice notice) throws Exception {
		//게시물 파일들 저장
		List<MultipartFile> files = notice.getFiles();
		for(MultipartFile file:files) {
			String filename = fileService.fileUpload(file); 		//파일을 저장
			if (filename.equals("")) continue;  //파일이름이 공백일경우 저장하지 않는다

			//게시물파일db저장 
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setNnum(notice.getNnum()); //게시물의 bnum세팅
			noticeFile.setFilename(filename);
			noticeFileRepository.insert(noticeFile);
		}
	}

	@Override
	public ErrorCode updateRemoveyn(int nnum) {
		noticeRepository.updateRemoveyn(nnum);
		return ErrorCode.SUCCESS_REMOVE;
	}

}
