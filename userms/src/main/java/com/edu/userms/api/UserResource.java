package com.edu.userms.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.userms.model.User;
import com.edu.userms.repo.UserRepo;


@RestController
public class UserResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
	
	@Autowired
	UserRepo userRepo;

	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World Manju!";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> findUserById(@PathVariable int id) {
		Optional<User> usersOpt = userRepo.findById(id);
		
		if(usersOpt.isPresent()) {
			LOGGER.info("User found with id {}", id);
			return ResponseEntity.ok(usersOpt.get());
		}
		LOGGER.info("User NOT found with id {}", id);
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
		User userSaved = userRepo.save(user);
		
		return ResponseEntity.created(new URI(userSaved.getId().toString())).body(userSaved);
	}
}
