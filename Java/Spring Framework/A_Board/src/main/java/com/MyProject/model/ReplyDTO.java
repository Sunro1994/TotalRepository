package com.MyProject.model;

public class ReplyDTO {
	private int reply_idx;
	private int board_idx;
	private String writer;
	private String content;
	private int reply_level;
	private int reply_h_idx;
	
	
	public int getReply_level() {
		return reply_level;
	}
	public void setReply_level(int reply_level) {
		this.reply_level = reply_level;
	}
	public int getReply_h_idx() {
		return reply_h_idx;
	}
	public void setReply_h_idx(int reply_h_idx) {
		this.reply_h_idx = reply_h_idx;
	}
	public int getReply_idx() {
		return reply_idx;
	}
	public void setReply_idx(int reply_idx) {
		this.reply_idx = reply_idx;
	}
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
