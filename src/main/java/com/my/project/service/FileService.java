package com.my.project.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

//공통모듈:파일을 처리
public interface FileService {
	//파일을 업로드 하고 파일명을 리턴
	String fileUpload(MultipartFile file) throws Exception;
	
	//파일 삭제
	void fileDelete(String filename) throws Exception;
	
	//파일 다운로드
	void fileDownload(String filename, HttpServletResponse res) throws Exception;
}
