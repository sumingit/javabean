package com.my.project.repository;

import java.util.List;

import com.my.project.dto.Reply;

//댓글 
public interface ReplyRepository {
	int insert(Reply reply);
	int update(Reply reply);
	int delete(int reply);
	Reply selectOne(int rnum);
	List<Reply> selectList(int bnum);
	
	/* 글순서 재수정 */
	int updateRestep(Reply reply);
}
