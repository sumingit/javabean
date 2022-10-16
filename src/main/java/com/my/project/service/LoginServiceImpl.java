package com.my.project.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.project.dto.Member;
import com.my.project.repository.MemberRepository;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private MemberRepository memberRepository; 
	
	//암호화 
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Override
	public Map<String, Object> loginCheck(String mid, String passwd, HttpSession session) {
		Map<String , Object> rmap = new HashMap<>();
		//code, msg
		//0 : 로그인 완료
		//1 : 아이디 미존재
		//2 : 비밀번호 불일치
		
		
		// 한건조회
		Member member = memberRepository.selectOne(mid);
		
		//1)아이디가 없다면 
		if (member == null) {
			rmap.put("code", 1);
			rmap.put("msg", "등록된 아이디가 없습니다.");
			return rmap;
		}
		
		//2)비밀번호
		//평문과 암호문을 비교(평문, 암호문)
		boolean match = bCryptPasswordEncoder.matches(passwd, member.getPasswd());
		if (!match) {
			rmap.put("code", 2);
			rmap.put("msg", "비밀번호 불일치");
			return rmap;
		}
		
		session.setAttribute("mid", mid);
		session.setAttribute("name", member.getName());
		session.setAttribute("mcode", member.getMcode());
		
		//성공
		rmap.put("code", 0);
		rmap.put("msg", "로그인 완료");
		return rmap;
	}



}
