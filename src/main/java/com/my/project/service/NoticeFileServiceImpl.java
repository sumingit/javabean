package com.my.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.project.dto.NoticeFile;
import com.my.project.repository.NoticeFileRepository;

@Service
public class NoticeFileServiceImpl implements NoticeFileService{
	
	@Autowired
	private NoticeFileRepository noticeFileRepository;
	
	@Override
	public List<NoticeFile> selectList(int nnum) {
		// TODO Auto-generated method stub
		return noticeFileRepository.selectList(nnum);
	}

}
