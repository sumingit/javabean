package com.my.project.dto;

public class Grade {
	private String gradecode;
	private String gradename;
	public Grade(String gradecode, String gradename) {
		super();
		this.gradecode = gradecode;
		this.gradename = gradename;
	}
	public String getGradecode() {
		return gradecode;
	}
	public void setGradecode(String gradecode) {
		this.gradecode = gradecode;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	@Override
	public String toString() {
		return "Grade [gradecode=" + gradecode + ", gradename=" + gradename + "]";
	}
	
}
