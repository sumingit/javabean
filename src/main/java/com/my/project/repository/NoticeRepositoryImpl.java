package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.dto.Notice;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Notice notice) {
		return sqlSession.insert("com.my.project.NoticeMapper.insert", notice);
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.NoticeMapper.update", notice);
	}

	@Override
	public int delete(int nnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.NoticeMapper.delete", nnum);
	}

	@Override
	public Notice selectOne(int nnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.NoticeMapper.selectOne", nnum);
	}

	@Override
	public List<Notice> selectList() {
		return sqlSession.selectList("com.my.project.NoticeMapper.selectList");
	}

	@Override
	public int updateReadCnt(int nnum) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.NoticeMapper.updateReadCnt", nnum);
	}

	@Override
	public int updateRemoveyn(int nnum) {
		//삭제여부 변경
		return sqlSession.update("com.my.project.NoticeMapper.updateRemoveyn", nnum);
	}


}
