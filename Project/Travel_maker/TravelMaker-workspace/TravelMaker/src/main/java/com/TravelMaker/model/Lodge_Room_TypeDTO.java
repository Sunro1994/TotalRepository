package com.TravelMaker.model;

import org.springframework.web.multipart.MultipartFile;

public class Lodge_Room_TypeDTO {
	private int lodge_Room_Type_Idx;
	private String lodge_Room_Type_Name;
	private int lodge_Room_Type_MinCapacity;
	private int lodge_Room_Type_MaxCapacity;
	private String lodge_Room_Type_Option;
	private String lodge_Room_Type_Img;
	private int lodge_Room_Type_price;
	private int lodge_Room_Type_Count;
	private int lodge_Idx;
	private int lodge_Room_Type_Coupon;
	private String lodge_Room_Type_IsDeleted;
	
	
	private String startDate;
	private String endDate;
	
	private MultipartFile imgFile;
	
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public int getLodge_Room_Type_MinCapacity() {
		return lodge_Room_Type_MinCapacity;
	}
	public void setLodge_Room_Type_MinCapacity(int lodge_Room_Type_MinCapacity) {
		this.lodge_Room_Type_MinCapacity = lodge_Room_Type_MinCapacity;
	}
	public int getLodge_Room_Type_MaxCapacity() {
		return lodge_Room_Type_MaxCapacity;
	}
	public void setLodge_Room_Type_MaxCapacity(int lodge_Room_Type_MaxCapacity) {
		this.lodge_Room_Type_MaxCapacity = lodge_Room_Type_MaxCapacity;
	}
	public String getLodge_Room_Type_Option() {
		return lodge_Room_Type_Option;
	}
	public void setLodge_Room_Type_Option(String lodge_Room_Type_Option) {
		this.lodge_Room_Type_Option = lodge_Room_Type_Option;
	}
	public String getLodge_Room_Type_Img() {
		return lodge_Room_Type_Img;
	}
	public void setLodge_Room_Type_Img(String lodge_Room_Type_Img) {
		this.lodge_Room_Type_Img = lodge_Room_Type_Img;
	}
	public int getLodge_Room_Type_price() {
		return lodge_Room_Type_price;
	}
	public void setLodge_Room_Type_price(int lodge_Room_Type_price) {
		this.lodge_Room_Type_price = lodge_Room_Type_price;
	}
	public int getLodge_Room_Type_Count() {
		return lodge_Room_Type_Count;
	}
	public void setLodge_Room_Type_Count(int lodge_Room_Type_Count) {
		this.lodge_Room_Type_Count = lodge_Room_Type_Count;
	}
	public int getLodge_Idx() {
		return lodge_Idx;
	}
	public void setLodge_Idx(int lodge_Idx) {
		this.lodge_Idx = lodge_Idx;
	}
	public int getLodge_Room_Type_Coupon() {
		return lodge_Room_Type_Coupon;
	}
	public void setLodge_Room_Type_Coupon(int lodge_Room_Type_Coupon) {
		this.lodge_Room_Type_Coupon = lodge_Room_Type_Coupon;
	}
	public String getLodge_Room_Type_IsDeleted() {
		return lodge_Room_Type_IsDeleted;
	}
	public void setLodge_Room_Type_IsDeleted(String lodge_Room_Type_IsDeleted) {
		this.lodge_Room_Type_IsDeleted = lodge_Room_Type_IsDeleted;
	}
	
}