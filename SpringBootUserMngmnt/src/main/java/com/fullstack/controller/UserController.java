package com.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.model.User;
import com.fullstack.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userServiceImpl;

	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody User user) {
		userServiceImpl.signUp(user);
		return ResponseEntity.ok("SignUp Done Successfully");
	}

	@GetMapping("/signin")
	public ResponseEntity<Boolean> signIn(@PathVariable String userEmailId, @PathVariable String userPassword) {
		return ResponseEntity.ok(userServiceImpl.signIn(userEmailId, userPassword));
	}

}
