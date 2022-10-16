package com.my.project.repository;

import java.util.List;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.M_Page;
import com.my.project.dto.Member;

public interface MemberRepository {

	int insert(Member member);
	Member selectOne(String mid);
	
	int mupdate(Member member);
	int update(Member member);
	int pwupdate(Member member);
	

	List<Member> selectList(M_Page m_page); //page는 페이징처리위한 정보
	//전체게시물수 구하기
	int selectTotalCnt(M_Page m_page);
	int delete(String mid);
	
}
