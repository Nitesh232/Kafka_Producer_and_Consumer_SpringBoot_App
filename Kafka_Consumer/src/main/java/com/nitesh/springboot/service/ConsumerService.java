package com.nitesh.springboot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nitesh.springboot.model.UserInfo;

@Service
public class ConsumerService {
	
	
	@KafkaListener(topics = "first_topic", groupId = "Consumer-group")
	public UserInfo listner(UserInfo info) {
		System.out.println("Message recieved :: "+info+ " :: successfully listening");
		return info;
	}
	
}
