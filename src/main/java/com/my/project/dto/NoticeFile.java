package com.my.project.dto;

public class NoticeFile {
	private int nfnum;
	private int nnum;
	private String filename;
	public int getNfnum() {
		return nfnum;
	}
	public void setNfnum(int nfnum) {
		this.nfnum = nfnum;
	}
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "NoticeFile [nfnum=" + nfnum + ", nnum=" + nnum + ", filename=" + filename + "]";
	}
	
	
}
