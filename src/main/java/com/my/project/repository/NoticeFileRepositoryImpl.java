package com.my.project.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.project.dto.NoticeFile;

@Repository
public class NoticeFileRepositoryImpl implements NoticeFileRepository{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(NoticeFile noticeFile) {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.my.project.NoticeFileMapper.insert", noticeFile);
	}

	@Override
	public int update(NoticeFile noticeFile) {
		// TODO Auto-generated method stub
		return sqlSession.update("com.my.project.NoticeFileMapper.update", noticeFile);
	}

	@Override
	public int delete(int nfnum) {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.my.project.NoticeFileMapper.delete", nfnum);
	}

	@Override
	public NoticeFile selectOne(int nfnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.my.project.NoticeFileMapper.selectOne", nfnum);
	}

	@Override
	public List<NoticeFile> selectList(int nnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.my.project.NoticeFileMapper.selectList", nnum);
	}

}
