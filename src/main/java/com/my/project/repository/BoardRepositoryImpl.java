package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.my.project.dto.Board;
import com.my.project.dto.B_Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepositoryImpl implements BoardRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Board board) {
		
		return sqlSession.insert("com.my.project.BoardMapper.insert", board);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.BoardMapper.update", board);
	}

	@Override
	public int delete(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.BoardMapper.delete", bnum);
	}

	@Override
	public Board selectOne(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.BoardMapper.selectOne", bnum);
	}

	@Override
	public List<Board> selectList(B_Page b_page) {
		return sqlSession.selectList("com.my.project.BoardMapper.selectList", b_page);
	}

	@Override
	public int selectTotalCnt(B_Page b_page) {
		// 전체게시물수 구하기
		return sqlSession.selectOne("com.my.project.BoardMapper.selectTotalCnt", b_page);
	}

	@Override
	public int updateReadCnt(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.BoardMapper.updateReadCnt", bnum);
	}

	@Override
	public int updateRemoveyn(int bnum) {
		//삭제여부 변경
		return sqlSession.update("com.my.project.BoardMapper.updateRemoveyn", bnum);
	}


}
