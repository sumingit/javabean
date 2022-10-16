package com.my.project.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String mid;
	private String email;
	private String name;
	private String passwd;
	private String birthday;	
	private String zipcode;
	private String addrload;
	private String addrdetail;
	private String mobile;
	private String tcode;
	private String gcode;
	private String mcode;
	private Date regidate;
	private Date modidate;
	private String filename;
	private String m_removeyn;
	private String teamname;
	private String gradename;
	
	
	MultipartFile photofile;


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddrload() {
		return addrload;
	}


	public void setAddrload(String addrload) {
		this.addrload = addrload;
	}


	public String getAddrdetail() {
		return addrdetail;
	}


	public void setAddrdetail(String addrdetail) {
		this.addrdetail = addrdetail;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getTcode() {
		return tcode;
	}


	public void setTcode(String tcode) {
		this.tcode = tcode;
	}


	public String getGcode() {
		return gcode;
	}


	public void setGcode(String gcode) {
		this.gcode = gcode;
	}


	public String getMcode() {
		return mcode;
	}


	public void setMcode(String mcode) {
		this.mcode = mcode;
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


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getM_removeyn() {
		return m_removeyn;
	}


	public void setM_removeyn(String m_removeyn) {
		this.m_removeyn = m_removeyn;
	}


	public String getTeamname() {
		return teamname;
	}


	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}


	public String getGradename() {
		return gradename;
	}


	public void setGradename(String gradename) {
		this.gradename = gradename;
	}


	public MultipartFile getPhotofile() {
		return photofile;
	}


	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}


	@Override
	public String toString() {
		return "Member [mid=" + mid + ", email=" + email + ", name=" + name + ", passwd=" + passwd + ", birthday="
				+ birthday + ", zipcode=" + zipcode + ", addrload=" + addrload + ", addrdetail=" + addrdetail
				+ ", mobile=" + mobile + ", tcode=" + tcode + ", gcode=" + gcode + ", mcode=" + mcode + ", regidate="
				+ regidate + ", modidate=" + modidate + ", filename=" + filename + ", m_removeyn=" + m_removeyn
				+ ", teamname=" + teamname + ", gradename=" + gradename + ", photofile=" + photofile + "]";
	}


	

	
}