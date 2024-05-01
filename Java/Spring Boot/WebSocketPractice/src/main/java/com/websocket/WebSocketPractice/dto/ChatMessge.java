package com.websocket.WebSocketPractice.dto;

import lombok.Data;

@Data
public class ChatMessge {
    public enum MessageType{
        ENTER,TALK
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

}
