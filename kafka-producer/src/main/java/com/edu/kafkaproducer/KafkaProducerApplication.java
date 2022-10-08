package com.edu.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaProducerApplication {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/messages/{mess}")
	public String pulish(@PathVariable String mess) {
		System.out.println("Message received: " + mess);
		kafkaTemplate.send("02_Oct_2020",mess);
		return mess;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApplication.class, args);
	}

}
