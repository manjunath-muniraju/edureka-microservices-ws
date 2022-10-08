package com.edu.kafkaconsumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumer1Application {
	
	@KafkaListener(topics = "02_Oct_2020", groupId = "a")
	public void consume(String mess) {
		System.out.println("Consumer-1: " + mess);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer1Application.class, args);
	}

}
