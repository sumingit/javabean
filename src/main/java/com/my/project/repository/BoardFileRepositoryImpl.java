package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.my.project.dto.BoardFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileRepositoryImpl implements BoardFileRepository{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.my.project.BoardFileMapper.insert", boardFile);
	}

	@Override
	public int update(BoardFile boardFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.BoardFileMapper.update", boardFile);
	}

	@Override
	public int delete(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.BoardFileMapper.delete", bfnum);
	}

	@Override
	public BoardFile selectOne(int bfnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.BoardFileMapper.selectOne", bfnum);
	}

	@Override
	public List<BoardFile> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.my.project.BoardFileMapper.selectList", bnum);
	}

}
