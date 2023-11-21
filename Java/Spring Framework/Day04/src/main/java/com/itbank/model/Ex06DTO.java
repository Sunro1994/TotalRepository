package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

public class Ex06DTO {
	private int idx;
	private String title;				// 입력된 파라미터를 그대로 DB에 저장[input:입력]
	private String fileName;			// 업로드 이후 만들어진 파일의 이름을 DB에 저장[저장]
	private MultipartFile upload;		// 입력받은 파일을 서버에 내려받기 위한 필드[input:입력]
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
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
