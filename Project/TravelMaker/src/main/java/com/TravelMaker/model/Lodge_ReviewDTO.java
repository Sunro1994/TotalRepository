package com.TravelMaker.model;

import java.sql.Date;

public class Lodge_ReviewDTO {
	private int lodge_Review_Idx;
	private String lodge_Review_Content;
	private int lodge_Review_Rate;
	private String lodge_Review_Writer;
	private int lodge_Review_RoomTypeIdx;
	private String lodge_Review_IsDeleted;
	private Date lodge_review_date;
	private String lodge_Room_Type_Name;
	
	
	
	public String getLodge_Room_Type_Name() {
		return lodge_Room_Type_Name;
	}
	public void setLodge_Room_Type_Name(String lodge_Room_Type_Name) {
		this.lodge_Room_Type_Name = lodge_Room_Type_Name;
	}
	public Date getLodge_review_date() {
		return lodge_review_date;
	}
	public void setLodge_review_date(Date lodge_review_date) {
		this.lodge_review_date = lodge_review_date;
	}
	public int getLodge_Review_Idx() {
		return lodge_Review_Idx;
	}
	public void setLodge_Review_Idx(int lodge_Review_Idx) {
		this.lodge_Review_Idx = lodge_Review_Idx;
	}
	public String getLodge_Review_Content() {
		return lodge_Review_Content;
	}
	public void setLodge_Review_Content(String lodge_Review_Content) {
		this.lodge_Review_Content = lodge_Review_Content;
	}
	public int getLodge_Review_Rate() {
		return lodge_Review_Rate;
	}
	public void setLodge_Review_Rate(int lodge_Review_Rate) {
		this.lodge_Review_Rate = lodge_Review_Rate;
	}
	public String getLodge_Review_Writer() {
		return lodge_Review_Writer;
	}
	public void setLodge_Review_Writer(String lodge_Review_Writer) {
		this.lodge_Review_Writer = lodge_Review_Writer;
	}
	public int getLodge_Review_RoomTypeIdx() {
		return lodge_Review_RoomTypeIdx;
	}
	public void setLodge_Review_RoomTypeIdx(int lodge_Review_RoomTypeIdx) {
		this.lodge_Review_RoomTypeIdx = lodge_Review_RoomTypeIdx;
	}
	public String getLodge_Review_IsDeleted() {
		return lodge_Review_IsDeleted;
	}
	public void setLodge_Review_IsDeleted(String lodge_Review_IsDeleted) {
		this.lodge_Review_IsDeleted = lodge_Review_IsDeleted;
	}
	
}