package com.my.project.repository;

import java.util.List;

import com.my.project.dto.Notice;

public interface NoticeRepository {
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int nnum);
	Notice selectOne(int nnum);
	List<Notice> selectList(); //page는 페이징처리위한 정보
	
	//조회수+1
	int updateReadCnt(int nnum);
	
	//삭제여부변경
	int updateRemoveyn(int nnum);
	
	
	
}
