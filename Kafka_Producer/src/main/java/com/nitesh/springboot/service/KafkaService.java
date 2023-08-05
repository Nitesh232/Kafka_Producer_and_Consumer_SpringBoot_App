package com.nitesh.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.nitesh.springboot.model.UserInfo;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, UserInfo> template;

	
	public String addDetails(UserInfo info) {
		template.send("first_topic", info);
		
		System.out.println(info.getName());
		
		return "record added successfully!";
	}
	
}
