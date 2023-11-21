package com.MyProject.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private int member_idx;
	private String userid;
	private String userpw;
	private String username;
	private Date birth;
	private String email;
	private MultipartFile profileImg;
	private String originalFileName;
	private String storedFileName;
	private String salt;
	private String findPassword;
	private String findAnswer;
	private String whoPushedLike;//WHOPUSHEDLIKE
	
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String origianlFileName) {
		this.originalFileName = origianlFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MultipartFile getProfileImg() {
		return profileImg;
	}
	public void setProfileImg(MultipartFile profileImg) {
		this.profileImg = profileImg;
	}
	public String getFindPassword() {
		return findPassword;
	}
	public void setFindPassword(String findPassword) {
		this.findPassword = findPassword;
	}
	public String getFindAnswer() {
		return findAnswer;
	}
	public void setFindAnswer(String findAnswer) {
		this.findAnswer = findAnswer;
	}
	public String getWhoPushedLike() {
		return whoPushedLike;
	}
	public void setWhoPushedLike(String whoPushedLike) {
		this.whoPushedLike = whoPushedLike;
	}
}
