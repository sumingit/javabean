package com.my.project.repository;

import java.util.List;

import com.my.project.dto.Board;
import com.my.project.dto.B_Page;





public interface BoardRepository {
	int insert(Board board);
	int update(Board board);
	int delete(int bnum);
	Board selectOne(int bnum);
	List<Board> selectList(B_Page b_page); //page는 페이징처리위한 정보
	//전체게시물수 구하기
	int selectTotalCnt(B_Page b_page);
	
	//조회수+1
	int updateReadCnt(int bnum);
	
	//삭제여부변경
	int updateRemoveyn(int bnum);
	
	
	
}
