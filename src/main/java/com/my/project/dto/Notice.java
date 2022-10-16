package com.my.project.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Notice {
	private int nnum;
	private String name;
	private String mid;
	private String subject;
	private String content;
	private int readcnt;
	private Date regidate;
	private String createtime;
	private Date modidate;
	private String n_removeyn;
	
	List<MultipartFile> files; //파일들 

	public int getNnum() {
		return nnum;
	}

	public void setNnum(int nnum) {
		this.nnum = nnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Date getModidate() {
		return modidate;
	}

	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}

	public String getN_removeyn() {
		return n_removeyn;
	}

	public void setN_removeyn(String n_removeyn) {
		this.n_removeyn = n_removeyn;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Notice [nnum=" + nnum + ", name=" + name + ", mid=" + mid + ", subject=" + subject + ", content="
				+ content + ", readcnt=" + readcnt + ", regidate=" + regidate + ", createtime=" + createtime
				+ ", modidate=" + modidate + ", n_removeyn=" + n_removeyn + ", files=" + files + "]";
	}

	


}
