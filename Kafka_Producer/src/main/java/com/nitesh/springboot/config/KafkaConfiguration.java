package com.nitesh.springboot.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nitesh.springboot.model.UserInfo;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, UserInfo> kafkaConfigs(){
		
		Map<String, Object> props = new HashMap<>();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS, JsonSerializer.class);
	
		
		
		return new DefaultKafkaProducerFactory<>(props);
	}
	
	@Bean
	public KafkaTemplate<String, UserInfo> template(){
		return new KafkaTemplate<String, UserInfo>(kafkaConfigs());
	}
	
}
