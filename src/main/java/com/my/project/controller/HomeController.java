package com.my.project.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.my.project.service.LoginService;


@Controller
public class HomeController {
	@Autowired
	private LoginService loginService;
	
	//홈으로 이동
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	//로그인 폼으로 이동
	@GetMapping("login")
	public void login() {
	}
	
	//로그인 버튼을 눌렀을때
	@PostMapping("login")
	public String login(@RequestParam String mid, @RequestParam String passwd,
			RedirectAttributes rattr, HttpSession session) {
		Map<String, Object> rmap = loginService.loginCheck(mid, passwd, session);
		//성공이면 홈 아니면 login로 이동
		int code = (int)rmap.get("code");
		rattr.addFlashAttribute("msg", rmap.get("msg"));

		if (code == 0 ) { //성공
			session.setAttribute("mid", mid);
			return "redirect:/";
		}
		return "redirect:login";
		
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		//세션지우기
		session.invalidate();
		
		return "redirect:/";
	}
	
}
