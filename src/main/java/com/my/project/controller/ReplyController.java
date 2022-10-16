package com.my.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.project.dto.Reply;
import com.my.project.service.ReplyService;

//댓글 처리 컨트롤러
@RestController //리턴값이 값자체를 반환하는 컨트롤러
@RequestMapping("reply")
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	//댓글추가
	//값자체를 리턴 
	//@RequestBody : jackson-databind 라이브러리 필요
	//@ResponseBody
	@PostMapping("/")
	public String add(@RequestBody Reply reply, HttpServletRequest request, HttpSession session) {
		reply.setMid((String)session.getAttribute("mid"));
		replyService.insert(reply);
		return "add success!";
	}
	
	//댓글의 리스트
	//@ResponseBody
	@GetMapping("list/{bnum}")
	public List<Reply> list(@PathVariable int bnum) {
		List<Reply> rlist = replyService.selectList(bnum);
		return rlist;
	}
	
	//댓글 삭제
	//@ResponseBody
	@DeleteMapping("{rnum}")
	public String remove(@PathVariable int rnum) {
		replyService.delete(rnum);
		return "remove ok!";
	}
	
	//댓글 수정
	//@ResponseBody
	@PutMapping("/")
	public String modify(@RequestBody Reply reply, HttpServletRequest request) {
		replyService.update(reply);
		return "modify ok!";
		
	}
	
	
	
	
	
}
