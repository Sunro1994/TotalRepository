package com.itbank.model;

public class YoutubeDTO {
	private int idx;
	private String title;
	private String channel;
	private int viewCount;
	private String thumbnail;
	private String movieTag;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getthumbnail() {
		return thumbnail;
	}
	public void setthumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getMovieTag() {
		return movieTag;
	}
	public void setMovieTag(String movieTag) {
		this.movieTag = movieTag;
	}
	
	
}
