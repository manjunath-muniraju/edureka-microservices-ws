package com.edu.kafkaconsumer2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumer2Application {
	
	@KafkaListener(topics = "02_Oct_2020", groupId = "a")
	public void consume(String mess) {
		System.out.println("Consumer-2: " + mess);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumer2Application.class, args);
	}

}
