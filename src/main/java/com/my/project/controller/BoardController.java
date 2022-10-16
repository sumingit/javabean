package com.my.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.project.advice.ErrorCode;

import com.my.project.dto.Board;
import com.my.project.dto.Member;
import com.my.project.dto.Notice;
import com.my.project.dto.B_Page;
import com.my.project.dto.Reply;
import com.my.project.service.BoardFileService;
import com.my.project.service.BoardService;
import com.my.project.service.FileService;
import com.my.project.service.MemberService;
import com.my.project.service.NoticeFileService;
import com.my.project.service.NoticeService;


@Controller
@RequestMapping("board")
@SessionAttributes("b_page") //1)세션에 담을 변수명: Page page; (초기 null) ;
public class BoardController {
	@Autowired
	private BoardService boardService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private BoardFileService boardFileService;
	@Autowired
	private NoticeFileService noticeFileService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private FileService fileService;
	
	@GetMapping("/")
	public String listhome(B_Page b_page, Model model) { //2)page객체 생성
		//세션에 객체를 할당하기 위한 목적(@SessionAttributes이 존재시 session생성)
		model.addAttribute("b_page", b_page); //3)세션에 할당
		// redirect방식 controller를 재호출
		return "redirect:list"; 
	}
	
	//@ModelAttribute("page") : @SessionAttributes가 있을때는 세션에도 저장
	//@SessionAttributes의 page에 객체할당후 실행
	//@ModelAttribute("page") : 생략가능
	@GetMapping("list")
	public void list(@ModelAttribute("b_page") B_Page b_page, Model model) {
		model.addAttribute("blist", boardService.selectList(b_page));
		model.addAttribute("nlist", noticeService.selectList());
		//@ModelAttribute :뷰까지 전달
		//model.addAttribute("page", page); //서비스에서 page 계산
		// WEB-INF/views/board/list.jsp로 이동
		
	}
	
	//상세페이지 이동
	@GetMapping("boardDetail")
	public void boardDetail(@RequestParam int bnum, Model model, Board board, HttpSession session, Reply reply) {
		//1)조회수+1
		boardService.updateReadCnt(bnum);
		//2)게시물 조회
		model.addAttribute("board", boardService.selectOne(bnum));
		//3)게시물파일들 조회
		model.addAttribute("bflist", boardFileService.selectList(bnum));

		// WEB-INF/views/board/boardDetail.jsp로 이동
	}

	@GetMapping("boardAdd")
	public void boardAdd(HttpSession session, Model model) {
		//추가페이지이동		
		String mid = (String) session.getAttribute("mid");
		Member member = memberService.selectOne(mid);
		model.addAttribute("member", member);
	}
	
	//게시물추가
	@PostMapping("boardAdd")
	public String boardAdd(Board board, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode =  boardService.insert(board);
		
		//board/ 로 이동해서 session page생성
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/board/";
		
	}
	
	
	//한건조회
	
	//수정폼으로 이동
	@GetMapping("boardModify")
	public String boardModify(Board board, @RequestParam int bnum, Model model, HttpSession session, RedirectAttributes rattr) {
		board = boardService.selectOne(bnum);
		String boardMid = board.getMid();
		String curMid = (String) session.getAttribute("mid");
		String curMcode = (String) session.getAttribute("mcode");
		if (boardMid.equals(curMid) || curMcode.equals("0")) {
			//1)게시물 조회
			model.addAttribute("board", boardService.selectOne(bnum));
			//2)게시물파일들 조회
			model.addAttribute("bflist", boardFileService.selectList(bnum));
			//board/boardModify.jsp로 이동
			return "/board/boardModify";
		}else {
			return "redirect:/";
		}
	}
	
	//수정버튼을 클릭했을때 
	//required = false :데이터가 없을때도 있다
	@PostMapping("boardModify")
	public String boardModify(Board board, 
			@RequestParam(required = false) List<Integer> removeFiles,
			HttpServletRequest request,
			RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode = boardService.update(board, removeFiles);
		
		//redirect방식, detail로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행 파라메터
		rattr.addAttribute("bnum", board.getBnum()); //url에 포함
		
		return "redirect:boardDetail";
	}
	
	//삭제버튼클릭시
	@GetMapping("boardRemove")
	public String boardRemove(Board board, @RequestParam int bnum, RedirectAttributes rattr, HttpSession session) {
		board = boardService.selectOne(bnum);
		String boardMid = board.getMid();
		String curMid = (String) session.getAttribute("mid");
		String curMcode = (String) session.getAttribute("mcode");
		if (boardMid.equals(curMid) || curMcode.equals("0")) {
			ErrorCode errorCode = boardService.updateRemoveyn(bnum);
			
			//redirect, list로 이동
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			return "redirect:list";
		}
		return "redirect:/";
	}
	
	
	

	
	
	
	//상세페이지 이동
	@GetMapping("noticeDetail")
	public void noticeDetail(@RequestParam int nnum, Model model, Notice notice) {
		//1)조회수+1
		noticeService.updateReadCnt(nnum);
		//2)게시물 조회
		model.addAttribute("notice", noticeService.selectOne(nnum));
		//3)게시물파일들 조회
		model.addAttribute("nflist", noticeFileService.selectList(nnum));
		
		// WEB-INF/views/board/noticeDetail.jsp로 이동
	}
	
	@GetMapping("noticeAdd")
	public void noticeAdd(HttpSession session, Model model) {
		String curMcode = (String) session.getAttribute("mcode");
		if (curMcode.equals("0")) {
			//추가페이지이동
			String mid = (String) session.getAttribute("mid");
			Member member = memberService.selectOne(mid);
			model.addAttribute("member", member);
		}
		
	}
	
	//공지추가
	@PostMapping("noticeAdd")
	public String noticeAdd(Notice notice, HttpServletRequest request, RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode =  noticeService.insert(notice);
		
		/// 로 이동해서 session page생성
		rattr.addFlashAttribute("msg", errorCode.getMsg());
		
		return "redirect:/board/";
		
		
	}
	
	//수정폼으로 이동
	@GetMapping("noticeModify")
	public void noticeModify(@RequestParam int nnum, Model model, HttpSession session) {
		String curMcode = (String) session.getAttribute("mcode");
		if (curMcode.equals("0")) {
			//1)게시물 조회
			model.addAttribute("notice", noticeService.selectOne(nnum));
			//2)게시물파일들 조회
			model.addAttribute("nflist", noticeFileService.selectList(nnum));
			//board/noticeModify.jsp로 이동
		}
	}
	
	//수정버튼을 클릭했을때 
	//required = false :데이터가 없을때도 있다
	@PostMapping("noticeModify")
	public String noticeModify(Notice notice, 
			@RequestParam(required = false) List<Integer> removeFiles,
			HttpServletRequest request,
			RedirectAttributes rattr) throws Exception {
		
		ErrorCode errorCode = noticeService.update(notice, removeFiles);
		
		//redirect방식, detail로 이동
		rattr.addFlashAttribute("msg", errorCode.getMsg()); //한번만 실행 파라메터
		rattr.addAttribute("nnum", notice.getNnum()); //url에 포함
		
		return "redirect:noticeDetail";
	}
	
	//삭제버튼클릭시
	@GetMapping("noticeRemove")
	public String noticeRemove(@RequestParam int nnum, RedirectAttributes rattr, HttpSession session) {
		String curMcode = (String) session.getAttribute("mcode");
		if (curMcode.equals("0")) {
			ErrorCode errorCode = noticeService.updateRemoveyn(nnum);
			//redirect, list로 이동
			rattr.addFlashAttribute("msg", errorCode.getMsg());
			return "redirect:list";
		}
		return "redirect:list";
		
	}
	
	//세션클리어
	@GetMapping("sessionClear")
	public String sessionClear(SessionStatus sessionStatus) {
		sessionStatus.setComplete(); //세션에서 지우기
		return "/board/list";
	}
	
	//파일다운로드
	@GetMapping("filedownload")
	public void filedownload(@RequestParam String filename, HttpServletResponse res) throws Exception {
		
		fileService.fileDownload(filename, res); //response객체 넘기기
		
	}

	
	
	
}
