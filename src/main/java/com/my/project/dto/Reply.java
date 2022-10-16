package com.my.project.dto;

import java.util.Date;

public class Reply {
	private int rnum;
	private int bnum;
	private String name;
	private String mid;
	private String content;
	private int restep;
	private int relevel;
	private Date regidate;
	private Date modidate;
	private String moditime;
	private String r_removeyn;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRestep() {
		return restep;
	}
	public void setRestep(int restep) {
		this.restep = restep;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}
	public Date getRegidate() {
		return regidate;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public Date getModidate() {
		return modidate;
	}
	public void setModidate(Date modidate) {
		this.modidate = modidate;
	}
	public String getModitime() {
		return moditime;
	}
	public void setModitime(String moditime) {
		this.moditime = moditime;
	}
	public String getR_removeyn() {
		return r_removeyn;
	}
	public void setR_removeyn(String r_removeyn) {
		this.r_removeyn = r_removeyn;
	}
	@Override
	public String toString() {
		return "Reply [rnum=" + rnum + ", bnum=" + bnum + ", name=" + name + ", mid=" + mid + ", content=" + content
				+ ", restep=" + restep + ", relevel=" + relevel + ", regidate=" + regidate + ", modidate=" + modidate
				+ ", moditime=" + moditime + ", r_removeyn=" + r_removeyn + "]";
	}
	
	
}