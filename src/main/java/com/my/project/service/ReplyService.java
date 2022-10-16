package com.my.project.service;

import java.util.List;

import com.my.project.dto.Reply;

public interface ReplyService {
	int insert(Reply reply);

	List<Reply> selectList(int bnum);

	int delete(int reply);

	int update(Reply reply);
	

}
