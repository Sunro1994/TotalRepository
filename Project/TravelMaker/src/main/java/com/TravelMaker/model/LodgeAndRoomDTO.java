package com.TravelMaker.model;

import java.util.Date;

public class LodgeAndRoomDTO {
	private int reserved_Lodge_current_state_idx;
	private int lodge_idx;
	private int lodge_Room_Type_Idx;
	private String lodge_Room_Type_Name;
	private String lodge_name;
	private String lodge_realimgname;
	private String lodge_Room_Type_Img;
	private Date reserved_Lodge_Current_State_StartDate;
	private Date reserved_Lodge_Current_State_EndDate;
    private String isReview;

	
	public String getIsReview() {
		return isReview;
	}
	public void setIsReview(String isReview) {
		this.isReview = isReview;
	}
	public Date getReserved_Lodge_Current_State_StartDate() {
		return reserved_Lodge_Current_State_StartDate;
	}
	public void setReserved_Lodge_Current_State_StartDate(Date reserved_Lodge_Current_State_StartDate) {
		this.reserved_Lodge_Current_State_StartDate = reserved_Lodge_Current_State_StartDate;
	}
	public Date getReserved_Lodge_Current_State_EndDate() {
		return reserved_Lodge_Current_State_EndDate;
	}
	public void setReserved_Lodge_Current_State_EndDate(Date reserved_Lodge_Current_State_EndDate) {
		this.reserved_Lodge_Current_State_EndDate = reserved_Lodge_Current_State_EndDate;
	}
	public int getReserved_Lodge_current_state_idx() {
		return reserved_Lodge_current_state_idx;
	}
	public void setReserved_Lodge_current_state_idx(int reserved_Lodge_current_state_idx) {
		this.reserved_Lodge_current_state_idx = reserved_Lodge_current_state_idx;
	}
	public int getLodge_idx() {
		return lodge_idx;
	}
	public void setLodge_idx(int lodge_idx) {
		this.lodge_idx = lodge_idx;
	}
	public int getLodge_Room_Type_Idx() {
		return lodge_Room_Type_Idx;
	}
	public void setLodge_Room_Type_Idx(int lodge_Room_Type_Idx) {
		this.lodge_Room_Type_Idx = lodge_Room_Type_Idx;
	}
	public String getLodge_Room_Type_Name() {
		return lodge_Room_Type_Name;
	}
	public void setLodge_Room_Type_Name(String lodge_Room_Type_Name) {
		this.lodge_Room_Type_Name = lodge_Room_Type_Name;
	}
	public String getLodge_name() {
		return lodge_name;
	}
	public void setLodge_name(String lodge_name) {
		this.lodge_name = lodge_name;
	}
	public String getLodge_realimgname() {
		return lodge_realimgname;
	}
	public void setLodge_realimgname(String lodge_realimgname) {
		this.lodge_realimgname = lodge_realimgname;
	}
	public String getLodge_Room_Type_Img() {
		return lodge_Room_Type_Img;
	}
	public void setLodge_Room_Type_Img(String lodge_Room_Type_Img) {
		this.lodge_Room_Type_Img = lodge_Room_Type_Img;
	}
	
	
	
	
	
}
