package com.my.project.service;

import java.util.List;

import com.my.project.advice.ErrorCode;
import com.my.project.dto.Board;
import com.my.project.dto.B_Page;

public interface BoardService {
	List<Board> selectList(B_Page b_page);
	Board selectOne(int bnum);
	//열거형 반환
	ErrorCode insert(Board board) throws Exception;
	ErrorCode update(Board board,List<Integer> removeFiles) throws Exception;
	ErrorCode updateRemoveyn(int bnum);
	
	//조회수+1
	int updateReadCnt(int bnum);
}
