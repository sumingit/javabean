package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.dto.MemberFile;

@Repository
public class MemberFileRepositoryImpl implements MemberFileRepository{
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(MemberFile memberFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.my.project.MemberFileMapper.insert", memberFile);
	}

	@Override
	public int update(MemberFile memberFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.MemberFileMapper.update", memberFile);
	}

	@Override
	public int delete(String mid) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.MemberFileMapper.delete", mid);
	}

	@Override
	public MemberFile selectOne(String mid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.MemberFileMapper.selectOne", mid);
	}

	@Override
	public List<MemberFile> selectList(String mid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.my.project.MemberFileMapper.selectList", mid);
	}

}
