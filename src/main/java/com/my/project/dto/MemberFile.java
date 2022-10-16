package com.my.project.dto;

public class MemberFile {
	private String mid;
	private String name;
	private String filename;
	public MemberFile(String mid, String name, String filename) {
		super();
		this.mid = mid;
		this.name = name;
		this.filename = filename;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	@Override
	public String toString() {
		return "MemberFile [mid=" + mid + ", name=" + name + ", filename=" + filename + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
