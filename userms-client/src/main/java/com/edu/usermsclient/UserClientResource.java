package com.edu.usermsclient;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserClientResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserClientResource.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/users-client/{id}")
	public Object getUsersFromUsers(@PathVariable String id) {
		LOGGER.info("About to call userms");
		return restTemplate.getForObject("http://userms/users/" + id, Object.class);
	}

}
