package com.mbk.dev.chatApp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/konu/genel")
	public ChatMessageModel sendMessage(@Payload ChatMessageModel model , SimpMessageHeaderAccessor s) {
		
		return model;
		
	}
	
	@MessageMapping("/chat.addUser")
    @SendTo("/konu/genel")
    public ChatMessageModel addUser(@Payload ChatMessageModel model, SimpMessageHeaderAccessor headerAccessor) {
        
// Add username in web socket session
    headerAccessor.getSessionAttributes().put("username", model.getSender());
        return model;
    }
	

}
