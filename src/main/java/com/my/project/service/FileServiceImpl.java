package com.my.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
	//자동주입(DI),이름,타입
	//root-context.xml의 정의된 bean주입
//	@Autowired
//	private String savedir;
	
	//application.properties의 환경설정값
	@Value("${file.savedir}")
	private String savedir;
	
	
	@Override
	public String fileUpload(MultipartFile file) throws Exception {
			
		//파일을 업로드 하고 파일명을 리턴
		String originFileName =file.getOriginalFilename();
		if (originFileName.equals("")) return ""; //파일이름이 없다면
		//파일이름이 겹치지 않도록 시스템날짜를 붙이기
		String filename = System.currentTimeMillis() + "_"+ originFileName;
		
		//저장할 디렉토리 생성

		if (!new File(savedir).isDirectory()) { //경로명이 없다면
			Files.createDirectory(Paths.get(savedir)); //경로명 path생성후 디렉토리 생성
		}
		
		//파일을 전송
		file.transferTo(new File(savedir, filename));
		
		return filename;
	}


	@Override
	public void fileDelete(String filename) throws Exception {
		// TODO Auto-generated method stub
		String savedirToday = savedir + "/20220519" ; //C:\Users\dw_sh\Desktop\Mung\savedir
		File file = new File(savedirToday + "/" + filename);
		if (file.isFile()) {
			file.delete();
		}
		
	}
	

	@Override
	public void fileDownload(String filename, HttpServletResponse res) throws Exception {
		// 파일 다운로드 경로
		String fileUrl = savedir + "/" + filename;
		//파일 읽기 스트림
		FileInputStream fis = new FileInputStream(fileUrl);
		
		//한글파일이름 인코딩
		filename = URLEncoder.encode(filename, "utf-8");
		
		//첨부파일로 파일 전송
		res.setHeader("Content-Disposition", "attachment;filename=" + filename);
		
		//파일 내보내기 스트림 생성
		OutputStream out = res.getOutputStream();
		//input stream 에서 읽어서 out으 stream로 보내기
		FileCopyUtils.copy(fis, out);
		
	}
}
