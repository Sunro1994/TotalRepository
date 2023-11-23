package com.TravelMaker.model;

public class ChatMessage {

    private String from;
    private String content;
    private String roomId;


    @Override
    public String toString() {
        return "받은 메시지: " + from + content;
    }


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getRoomId() {
		return roomId;
	}


	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
    
    
}