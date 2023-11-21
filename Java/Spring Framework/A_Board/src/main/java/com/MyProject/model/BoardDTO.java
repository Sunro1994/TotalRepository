package com.MyProject.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private int board_idx;
	private int writer_idx;
	private String title;
	private String writer;
	private Date wdate;
	private String content;
	private MultipartFile contentImg;
	private String storedFileName;
	private String originalFileName;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public int getWriter_idx() {
		return writer_idx;
	}
	public void setWriter_idx(int writer_idx) {
		this.writer_idx = writer_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MultipartFile getContentImg() {
		return contentImg;
	}
	public void setContentImg(MultipartFile contentImg) {
		this.contentImg = contentImg;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	
}
