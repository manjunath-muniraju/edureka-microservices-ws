package com.edu.userms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.userms.model.User;
import com.edu.userms.repo.UserRepo;

@RestController
public class UserResource {
	
	@Autowired
	UserRepo userRepo;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello World Manju!";
	}
}
