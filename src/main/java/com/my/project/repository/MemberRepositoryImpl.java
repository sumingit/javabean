package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.M_Page;
import com.my.project.dto.Member;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public int insert(Member member) {
		return sqlSession.insert("com.my.project.MemberMapper.insert", member);
	}
	
	
	@Override
	public Member selectOne(String mid) {
		
		return sqlSession.selectOne("com.my.project.MemberMapper.selectOne", mid);
	}
	
	@Override
	public int mupdate(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.MemberMapper.mupdate", member);
	}

	@Override
	public int update(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.MemberMapper.update", member);
	}

	@Override
	public int pwupdate(Member member) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.MemberMapper.pwupdate", member);
	}


	@Override
	public List<Member> selectList(M_Page m_page) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.my.project.MemberMapper.selectList", m_page);
	}


	@Override
	public int selectTotalCnt(M_Page m_page) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.MemberMapper.selectTotalCnt", m_page);
	}


	@Override
	public int delete(String mid) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.MemberMapper.delete", mid);
	}

	
}
