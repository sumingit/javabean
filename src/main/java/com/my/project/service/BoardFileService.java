package com.my.project.service;

import java.util.List;

import com.my.project.dto.BoardFile;

public interface BoardFileService {
	//boardfile db에 접근
	List<BoardFile> selectList(int bnum);
	
}
