package com.my.project.repository;

import java.util.List;

import com.my.project.dto.NoticeFile;

public interface NoticeFileRepository {
	int insert(NoticeFile noticeFile);
	int update(NoticeFile noticeFile);
	int delete(int nfnum);
	NoticeFile selectOne(int nfnum);
	List<NoticeFile> selectList(int nnum);
}