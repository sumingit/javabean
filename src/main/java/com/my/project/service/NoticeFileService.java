package com.my.project.service;

import java.util.List;

import com.my.project.dto.NoticeFile;

public interface NoticeFileService {
	//noticefile db에 접근
	List<NoticeFile> selectList(int nnum);
	
}
