package com.my.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.M_Page;
import com.my.project.dto.Member;


//인터페이스의 메소드는 추상메소드:구현부가 없다
public interface MemberService {

	Map<String, Object> insert(Member member);
	
	ErrorCode mupdate(Member member) throws Exception;
	
	ErrorCode update(Member member) throws Exception;

	ErrorCode pwupdate(Member member, String newPasswd, String newPasswd2) ;
	
	List<Member> selectList(M_Page m_page);
	
	Member selectOne(String mid);
	
	ErrorCode delete(String mid, HttpSession session);

}
