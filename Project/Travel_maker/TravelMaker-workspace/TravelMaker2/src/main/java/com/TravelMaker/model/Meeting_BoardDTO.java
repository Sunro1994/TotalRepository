package com.TravelMaker.model;

import java.sql.Date;

public class Meeting_BoardDTO {
	private int meeting_Board_Idx;
	private Date meeting_Board_Date;
	private String meeting_Board_Content;
	private String meeting_Board_Location;
	private String meeting_Board_Writer;
	private String meeting_Board_IsDeleted;
	
	// 닉네임
	private String meeting_Board_Nickname;
	
	public String getMeeting_Board_Nickname() {
		return meeting_Board_Nickname;
	}
	public void setMeeting_Board_Nickname(String meeting_Board_Nickname) {
		this.meeting_Board_Nickname = meeting_Board_Nickname;
	}
	
	public int getMeeting_Board_Idx() {
		return meeting_Board_Idx;
	}
	public void setMeeting_Board_Idx(int meeting_Board_Idx) {
		this.meeting_Board_Idx = meeting_Board_Idx;
	}
	public Date getMeeting_Board_Date() {
		return meeting_Board_Date;
	}
	public void setMeeting_Board_Date(Date meeting_Board_Date) {
		this.meeting_Board_Date = meeting_Board_Date;
	}
	public String getMeeting_Board_Content() {
		return meeting_Board_Content;
	}
	public void setMeeting_Board_Content(String meeting_Board_Content) {
		this.meeting_Board_Content = meeting_Board_Content;
	}
	public String getMeeting_Board_Location() {
		return meeting_Board_Location;
	}
	public void setMeeting_Board_Location(String meeting_Board_Location) {
		this.meeting_Board_Location = meeting_Board_Location;
	}
	public String getMeeting_Board_Writer() {
		return meeting_Board_Writer;
	}
	public void setMeeting_Board_Writer(String meeting_Board_Writer) {
		this.meeting_Board_Writer = meeting_Board_Writer;
	}
	public String getMeeting_Board_IsDeleted() {
		return meeting_Board_IsDeleted;
	}
	public void setMeeting_Board_IsDeleted(String meeting_Board_IsDeleted) {
		this.meeting_Board_IsDeleted = meeting_Board_IsDeleted;
	}
}
