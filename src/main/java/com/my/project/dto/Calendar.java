package com.my.project.dto;

public class Calendar {
	private String title;
	private String start;
	private String end;
	private boolean allday;
	
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public boolean isAllday() {
		return allday;
	}
	public void setAllday(boolean allday) {
		this.allday = allday;
	}
	
	
	@Override
	public String toString() {
		return "Calendar [title=" + title + ", start=" + start + ", end=" + end + ", allday=" + allday
				+ "]";
	}
	
	
	public Calendar(int num, String title, String start, String end, boolean allday) {
		super();
		this.title = title;
		this.start = start;
		this.end = end;
		this.allday = allday;
	}
	public Calendar() {
		super();
	}
	
	
	
	
	
	

}
