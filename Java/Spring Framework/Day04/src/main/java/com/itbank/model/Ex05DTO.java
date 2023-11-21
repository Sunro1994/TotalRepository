package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class Ex05DTO {
	
	private String title;
	private MultipartFile upload;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
}
