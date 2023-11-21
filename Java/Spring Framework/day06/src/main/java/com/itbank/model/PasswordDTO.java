package com.itbank.model;

public class PasswordDTO {
	private String newPW;
	private String oldPW;
	private String newSalt;
	public String getNewPW() {
		return newPW;
	}
	public void setNewPW(String newPW) {
		this.newPW = newPW;
	}
	public String getOldPW() {
		return oldPW;
	}
	public void setOldPW(String oldPW) {
		this.oldPW = oldPW;
	}
	public String getNewSalt() {
		return newSalt;
	}
	public void setNewSalt(String newSalt) {
		this.newSalt = newSalt;
	}
}
