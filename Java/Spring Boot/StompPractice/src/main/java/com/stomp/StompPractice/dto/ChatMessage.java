package com.stomp.StompPractice.dto;

import lombok.Data;

@Data
public class ChatMessage {
    public enum MessageType{
        ENTER,TALK,JOIN
    }
    private MessageType type;
    private String roomId;
    private String sender;
    private String message;

}
