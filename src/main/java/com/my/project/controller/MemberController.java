package com.my.project.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.M_Page;
import com.my.project.dto.Member;
import com.my.project.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;

	// 가입폼으로 이동
	@GetMapping("join")
	public void join() {		
	}
	
	// 가입버튼을 클릭시
	@PostMapping("join") 
	public String join(@ModelAttribute Member member, Model model, RedirectAttributes rattr, HttpSession session) throws Exception {
		//파일 포함
		Map<String, Object> rmap =  memberService.insert(member);
		if ((int)rmap.get("code") == 0) { //성공했다면
			session.setMaxInactiveInterval(60*60*2);
			session.setAttribute("mid", member.getMid());
			session.setAttribute("name", member.getName());
			session.setAttribute("authCode", rmap.get("authCode"));
			return "redirect:/";	
		}
		//실패시(forward방식)
		//model.addAttribute("member", member); 생략
		model.addAttribute("msg", rmap.get("msg"));
		return "member/join";
		
	}
	
	@GetMapping("home")
	public void home() {
		
	}
	
	//주소를 호출
	@GetMapping("jusoPopup") 
	public void jusoPopup() {
		//member/jusoPopup.jsp호출
	}
	
	//주소검색후 callback
	@PostMapping("jusoPopup") 
	public void jusoPopup(@RequestParam Map<String, String> jusomap, Model model) {
		model.addAttribute("jusomap", jusomap);
	}

	@GetMapping("/")
	public String memberlisthome(M_Page m_page, Model model) {
		model.addAttribute("m_page", m_page);
		return "redirect:memberlist";
	}
	
	@GetMapping("memberlist")
	public void memberlist(@ModelAttribute("m_page") M_Page m_page, Model model) {
		model.addAttribute("mlist", memberService.selectList(m_page));
		
	}
	
	@GetMapping("memberdetail")
	public void memberdetail(@RequestParam(value ="mid", required = false) String mid, Model model) {
		model.addAttribute("member", memberService.selectOne(mid)); 
		
	}
	
	@GetMapping("membermodify")
	public String membermodify(Member member, String mid, Model model, HttpSession session, RedirectAttributes rattr) {
		member = memberService.selectOne(mid);
		String memberMid = member.getMid();
		String curMid = (String) session.getAttribute("mid");
		String curMcode = (String) session.getAttribute("mcode");
		if (memberMid.equals(curMid) || curMcode.equals("0")) {
			model.addAttribute("member", memberService.selectOne(mid));
			return "/member/membermodify";
		}else {
			return "redirect:/";
		}
		
	}
	

	 // 회원 수정 저장
	  
	 @PostMapping("membermodify") 
	 public String membermodify(Member member,RedirectAttributes rattr, HttpSession session) throws Exception {
		 String curMcode = (String) session.getAttribute("mcode");
		 if(curMcode.equals("0")) {
			 ErrorCode errorCode = memberService.mupdate(member);
			 rattr.addAttribute("mid", member.getMid()); //url에 포함 System.out.println(member.getMid()); 
			 return "redirect:/member/memberdetail";
		 }else {
			 ErrorCode errorCode = memberService.update(member); 
			 rattr.addAttribute("mid", member.getMid()); //url에 포함 System.out.println(member.getMid()); 
			 return "redirect:/member/memberdetail"; 
		 }
	 }
	 


	  @GetMapping("newpasswd")
	  public String newpasswd(Member member, String mid, Model model, HttpSession session, RedirectAttributes rattr) {
		  member = memberService.selectOne(mid);
		  String memberMid = member.getMid();
  		  String curMid = (String) session.getAttribute("mid");
		  if (memberMid.equals(curMid)) {
			  member = memberService.selectOne(mid);
			  model.addAttribute("member", member);
			  return "/member/newpasswd";
		  }else {
			  return "redirect:/";
		  }
	  }
	  

	  @PostMapping("newpasswd")
	  public String newpasswd(Member member, String mid, String oldPasswd, String newPasswd, Model model,RedirectAttributes rattr) {
		  member = memberService.selectOne(mid);
		  ErrorCode errorCode = memberService.pwupdate(member, oldPasswd, newPasswd);
		  if (errorCode.getCode() != 0) { //실패시
			  model.addAttribute("msg", errorCode.getMsg());
			  return "member/newpasswd";
		  }else { //성공시 info
			  rattr.addFlashAttribute("msg", errorCode.getMsg());
			  rattr.addAttribute("mid", member.getMid());
			  return "redirect:/member/memberdetail";
		  }
	
	  }
	  @GetMapping("memberdelete")
	  public String memberdelete(String mid, HttpSession session, Model model) {
		  ErrorCode errorCode = memberService.delete(mid, session);
		  if (errorCode.getCode() != 0) { //실패시
			  model.addAttribute("msg", errorCode.getMsg());
			  return "/member/memberlist";
		  }else { //성공시 info
			  return "/member/memberlist";
		  }
		  
	  }
	
}
