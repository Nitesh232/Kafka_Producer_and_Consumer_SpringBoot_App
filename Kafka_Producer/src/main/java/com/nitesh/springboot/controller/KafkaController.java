package com.nitesh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nitesh.springboot.model.UserInfo;
import com.nitesh.springboot.service.KafkaService;

@RestController
public class KafkaController {

	@Autowired
	private KafkaService service;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUser(@RequestBody UserInfo info){
		
		String addDetails = service.addDetails(info);
		
		return ResponseEntity.ok(addDetails);
	}
	
}
