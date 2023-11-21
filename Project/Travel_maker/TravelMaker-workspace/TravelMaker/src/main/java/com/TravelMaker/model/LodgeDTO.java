package com.TravelMaker.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class LodgeDTO {
	private int lodge_idx;
	private String lodge_name;
	private String lodge_ckReservation; //LODGE_CKRESERVATION
	private int lodge_rate;
	private String lodge_type;
	private String lodge_realimgname;
	private String lodge_address;
	private String lodge_tel;
	private String lodge_option;
	private String lodge_locationcode;
	private String lodge_content;
	private int lodge_Sellerinfo_businessnum;
	private String lodge_isdeleted;
	
	private List<String> areaArr;
	private List<String> typeArr;
	private String startDate;
	private String endDate;
	
	private MultipartFile imgFile;
	
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
	public int getLodge_idx() {
		return lodge_idx;
	}
	public void setLodge_idx(int lodge_idx) {
		this.lodge_idx = lodge_idx;
	}
	public String getLodge_name() {
		return lodge_name;
	}
	public void setLodge_name(String lodge_name) {
		this.lodge_name = lodge_name;
	}
	public String getLodge_ckReservation() {
		return lodge_ckReservation;
	}
	public void setLodge_ckReservation(String lodge_ckReservation) {
		this.lodge_ckReservation = lodge_ckReservation;
	}
	public int getLodge_rate() {
		return lodge_rate;
	}
	public void setLodge_rate(int lodge_rate) {
		this.lodge_rate = lodge_rate;
	}
	public String getLodge_type() {
		return lodge_type;
	}
	public void setLodge_type(String lodge_type) {
		this.lodge_type = lodge_type;
	}
	public String getLodge_realimgname() {
		return lodge_realimgname;
	}
	public void setLodge_realimgname(String lodge_realimgname) {
		this.lodge_realimgname = lodge_realimgname;
	}
	public String getLodge_address() {
		return lodge_address;
	}
	public void setLodge_address(String lodge_address) {
		this.lodge_address = lodge_address;
	}
	public String getLodge_tel() {
		return lodge_tel;
	}
	public void setLodge_tel(String lodge_tel) {
		this.lodge_tel = lodge_tel;
	}
	public String getLodge_option() {
		return lodge_option;
	}
	public void setLodge_option(String lodge_option) {
		this.lodge_option = lodge_option;
	}
	public String getLodge_locationcode() {
		return lodge_locationcode;
	}
	public void setLodge_locationcode(String lodge_locationcode) {
		this.lodge_locationcode = lodge_locationcode;
	}
	public String getLodge_content() {
		return lodge_content;
	}
	public void setLodge_content(String lodge_content) {
		this.lodge_content = lodge_content;
	}
	public int getLodge_Sellerinfo_businessnum() {
		return lodge_Sellerinfo_businessnum;
	}
	public void setLodge_Sellerinfo_businessnum(int lodge_Sellerinfo_businessnum) {
		this.lodge_Sellerinfo_businessnum = lodge_Sellerinfo_businessnum;
	}
	public String getLodge_isdeleted() {
		return lodge_isdeleted;
	}
	public void setLodge_isdeleted(String lodge_isdeleted) {
		this.lodge_isdeleted = lodge_isdeleted;
	}
	public List<String> getAreaArr() {
		return areaArr;
	}
	public void setAreaArr(List<String> areaArr) {
		this.areaArr = areaArr;
	}
	public List<String> getTypeArr() {
		return typeArr;
	}
	public void setTypeArr(List<String> typeArr) {
		this.typeArr = typeArr;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	
	
	
	
	
	
}