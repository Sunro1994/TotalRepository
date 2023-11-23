package com.TravelMaker.model;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;

public class TravelMaker_MemberDTO {
	private int travelMaker_Member_Idx;
	private String travelMaker_Member_UserId;
	private String travelMaker_Member_UserPw;
	private String travelMaker_Member_Salt;
	private String travelMaker_Member_UserName;
	private String travelMaker_Member_UserNickName;
	private String travelMaker_Member_Email;
	private String travelMaker_Member_Birth;
	private String travelMaker_Member_Gender;
	private MultipartFile upload;
	private String travelMaker_Member_EncodingProfileImg;
	private String travelMaker_Member_Pnum;
	private int travelMaker_Member_ReservedLodge;
	private String travelMaker_Member_IsAdmin;
	private String travelMaker_Member_Favorite;
	private int travelMaker_Member_Coupon;
	private String travelMaker_Member_IsExist;
	private int useCoupon;
	
	private String isKakao;
	private String isGoogle;
	private String isNaver;

	public String getIsNaver() {
		return isNaver;
	}

	public void setIsNaver(String isNaver) {
		this.isNaver = isNaver;
	}

	public String getIsKakao() {
		return isKakao;
	}

	public void setIsKakao(String isKakao) {
		this.isKakao = isKakao;
	}

	public String getIsGoogle() {
		return isGoogle;
	}

	public void setIsGoogle(String isGoogle) {
		this.isGoogle = isGoogle;
	}

	public int getTravelMaker_Member_Idx() {
		return travelMaker_Member_Idx;
	}

	public void setTravelMaker_Member_Idx(int travelMaker_Member_Idx) {
		this.travelMaker_Member_Idx = travelMaker_Member_Idx;
	}

	public String getTravelMaker_Member_UserId() {
		return travelMaker_Member_UserId;
	}

	public void setTravelMaker_Member_UserId(String travelMaker_Member_UserId) {
		this.travelMaker_Member_UserId = travelMaker_Member_UserId;
	}

	public String getTravelMaker_Member_UserPw() {
		return travelMaker_Member_UserPw;
	}

	public void setTravelMaker_Member_UserPw(String travelMaker_Member_UserPw) {
		this.travelMaker_Member_UserPw = travelMaker_Member_UserPw;
	}

	public String getTravelMaker_Member_Salt() {
		return travelMaker_Member_Salt;
	}

	public void setTravelMaker_Member_Salt(String travelMaker_Member_Salt) {
		this.travelMaker_Member_Salt = travelMaker_Member_Salt;
	}

	public String getTravelMaker_Member_UserName() {
		return travelMaker_Member_UserName;
	}

	public void setTravelMaker_Member_UserName(String travelMaker_Member_UserName) {
		this.travelMaker_Member_UserName = travelMaker_Member_UserName;
	}

	public String getTravelMaker_Member_UserNickName() {
		return travelMaker_Member_UserNickName;
	}

	public void setTravelMaker_Member_UserNickName(String travelMaker_Member_UserNickName) {
		this.travelMaker_Member_UserNickName = travelMaker_Member_UserNickName;
	}

	public String getTravelMaker_Member_Email() {
		return travelMaker_Member_Email;
	}

	public void setTravelMaker_Member_Email(String travelMaker_Member_Email) {
		this.travelMaker_Member_Email = travelMaker_Member_Email;
	}

	public String getTravelMaker_Member_Birth() {
		return travelMaker_Member_Birth;
	}

	public void setTravelMaker_Member_Birth(String travelMaker_Member_Birth) {
		this.travelMaker_Member_Birth = travelMaker_Member_Birth;
	}

	public String getTravelMaker_Member_Gender() {
		return travelMaker_Member_Gender;
	}

	public void setTravelMaker_Member_Gender(String travelMaker_Member_Gender) {
		this.travelMaker_Member_Gender = travelMaker_Member_Gender;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}

	public String getTravelMaker_Member_EncodingProfileImg() {
		return travelMaker_Member_EncodingProfileImg;
	}

	public void setTravelMaker_Member_EncodingProfileImg(String travelMaker_Member_EncodingProfileImg) {
		this.travelMaker_Member_EncodingProfileImg = travelMaker_Member_EncodingProfileImg;
	}

	public String getTravelMaker_Member_Pnum() {
		return travelMaker_Member_Pnum;
	}

	public void setTravelMaker_Member_Pnum(String travelMaker_Member_Pnum) {
		this.travelMaker_Member_Pnum = travelMaker_Member_Pnum;
	}

	public int getTravelMaker_Member_ReservedLodge() {
		return travelMaker_Member_ReservedLodge;
	}

	public void setTravelMaker_Member_ReservedLodge(int travelMaker_Member_ReservedLodge) {
		this.travelMaker_Member_ReservedLodge = travelMaker_Member_ReservedLodge;
	}

	public String getTravelMaker_Member_IsAdmin() {
		return travelMaker_Member_IsAdmin;
	}

	public void setTravelMaker_Member_IsAdmin(String travelMaker_Member_IsAdmin) {
		this.travelMaker_Member_IsAdmin = travelMaker_Member_IsAdmin;
	}

	public String getTravelMaker_Member_Favorite() {
		return travelMaker_Member_Favorite;
	}

	public void setTravelMaker_Member_Favorite(String travelMaker_Member_Favorite) {
		this.travelMaker_Member_Favorite = travelMaker_Member_Favorite;
	}

	public int getTravelMaker_Member_Coupon() {
		return travelMaker_Member_Coupon;
	}

	public void setTravelMaker_Member_Coupon(int travelMaker_Member_Coupon) {
		this.travelMaker_Member_Coupon = travelMaker_Member_Coupon;
	}

	public String getTravelMaker_Member_IsExist() {
		return travelMaker_Member_IsExist;
	}

	public void setTravelMaker_Member_IsExist(String travelMaker_Member_IsExist) {
		this.travelMaker_Member_IsExist = travelMaker_Member_IsExist;
	}

	public int getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(int useCoupon) {
		this.useCoupon = useCoupon;
	}
}
