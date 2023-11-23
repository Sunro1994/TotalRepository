package com.TravelMaker.controller.meeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.TravelMaker.model.ChatMessage;

@Controller
public class ChatController {

	  @Autowired private final SimpMessagingTemplate messagingTemplate;

	    public ChatController(SimpMessagingTemplate messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	    }

	    @MessageMapping("/enter")
	    public void sendMessage(ChatMessage chatMessage) {
	        System.out.println(chatMessage.toString());
	        messagingTemplate.convertAndSend("/broker/room/" + chatMessage.getRoomId(), chatMessage);
	    }
}
