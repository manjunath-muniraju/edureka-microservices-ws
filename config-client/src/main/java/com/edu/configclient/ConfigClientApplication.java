package com.edu.configclient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {
	
	@Value("${my-property}")
	String myProperty;
	
	@Value("${your-property}")
	String yourProperty;
	
	@Value("${common.property}")
	String commonProperty;
	
	@GetMapping("/properties")
	public Map<String, String> getAllProperties() {
		HashMap<String, String> properties = new HashMap<>();
		
		properties.put("myProperty", myProperty);
		properties.put("yourProperty", yourProperty);
		properties.put("commonProperty", commonProperty);
		
		return properties;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
