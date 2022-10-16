package com.my.project.service;

import java.util.List;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.Notice;

public interface NoticeService {
	List<Notice> selectList();
	Notice selectOne(int nnum);
	//열거형 반환
	ErrorCode insert(Notice notice) throws Exception;
	ErrorCode update(Notice notice,List<Integer> removeFiles) throws Exception;
	ErrorCode updateRemoveyn(int bnum);
	
	//조회수+1
	int updateReadCnt(int nnum);
}
