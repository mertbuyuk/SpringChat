package com.mbk.dev.chatApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// bu yöntemde istemcinin webserver ile bağlantı kurması için endpoint oluşturuyoruz
		registry.addEndpoint("/server").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//istemciden gelen mesajı grup sohbetindeki bir başka kişiye göndermek için kullanılır 
		registry.setApplicationDestinationPrefixes("/uyg");
		registry.enableSimpleBroker("/konu");
	}
	

}
