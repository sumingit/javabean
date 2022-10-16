package com.my.project.dto;

public class Team {
	private String teamcode;
	private String teamname;
	public Team(String teamcode, String teamname) {
		super();
		this.teamcode = teamcode;
		this.teamname = teamname;
	}
	public String getTeamcode() {
		return teamcode;
	}
	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}
	public String getTeamname() {
		return teamname;
	}
	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	@Override
	public String toString() {
		return "team [teamcode=" + teamcode + ", teamname=" + teamname + "]";
	}
	
	
	
	
	
	
	
	
}
