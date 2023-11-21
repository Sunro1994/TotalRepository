package com.TravelMaker.model;

import java.util.Date;

public class Meeting_BoardDTO {
	private int meeting_Board_Idx;
	private Date meeting_Board_Date;
	private String meeting_Board_Content;
	private String meeting_Board_Location;
	private String meeting_Board_Writer;
	private String meeting_Board_IsDeleted;
	public int getmeeting_Board_Idx() {
		return meeting_Board_Idx;
	}
	public void setmeeting_Board_Idx(int meeting_Board_Idx) {
		meeting_Board_Idx = meeting_Board_Idx;
	}
	public Date getmeeting_Board_Date() {
		return meeting_Board_Date;
	}
	public void setmeeting_Board_Date(Date meeting_Board_Date) {
		meeting_Board_Date = meeting_Board_Date;
	}
	public String getmeeting_Board_Content() {
		return meeting_Board_Content;
	}
	public void setmeeting_Board_Content(String meeting_Board_Content) {
		meeting_Board_Content = meeting_Board_Content;
	}
	public String getmeeting_Board_Location() {
		return meeting_Board_Location;
	}
	public void setmeeting_Board_Location(String meeting_Board_Location) {
		meeting_Board_Location = meeting_Board_Location;
	}
	public String getmeeting_Board_Writer() {
		return meeting_Board_Writer;
	}
	public void setmeeting_Board_Writer(String meeting_Board_Writer) {
		meeting_Board_Writer = meeting_Board_Writer;
	}
	public String getmeeting_Board_IsDeleted() {
		return meeting_Board_IsDeleted;
	}
	public void setmeeting_Board_IsDeleted(String meeting_Board_IsDeleted) {
		meeting_Board_IsDeleted = meeting_Board_IsDeleted;
	}
}
