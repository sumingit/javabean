package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.dto.Reply;

@Repository
public class ReplyRepositoryImpl implements ReplyRepository{
	@Autowired
	private SqlSession sqlSession; 

	@Override
	public int insert(Reply reply) {
		return sqlSession.insert("com.my.project.ReplyMapper.insert", reply);
	}

	@Override
	public int update(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.ReplyMapper.update", reply);
	}

	@Override
	public int delete(int reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.ReplyMapper.delete", reply);
	}

	@Override
	public Reply selectOne(int rnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.ReplyMapper.selectOne", rnum);
	}

	@Override
	public List<Reply> selectList(int bnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.my.project.ReplyMapper.selectList", bnum);
	}

	@Override
	public int updateRestep(Reply reply) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.ReplyMapper.updateRestep", reply);
	}

}
