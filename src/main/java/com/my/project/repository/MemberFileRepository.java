package com.my.project.repository;

import java.util.List;

import com.my.project.dto.MemberFile;

public interface MemberFileRepository {
	int insert(MemberFile memberFile);
	int update(MemberFile memberFile);
	int delete(String mid);
	MemberFile selectOne(String mid);
	List<MemberFile> selectList(String mid);
}