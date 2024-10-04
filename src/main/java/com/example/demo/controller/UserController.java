package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/login")
	public User login(@RequestBody User u) {
		User us = null;
		Optional<User> userdata = userRepository.findByEmail(u.getEmail());
		if(userdata.isPresent()) {
			us = userdata.get();
			if(us.getEmail().equals(u.getEmail()) && us.getPassword().equals(u.getPassword())){
				return us;
			}
		}
		return null;
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User u) {
		Optional<User> userdata = userRepository.findByEmail(u.getEmail());
		if(userdata.isPresent()) {
			return null;
		}
		return userRepository.save(u);
	}
	
}
