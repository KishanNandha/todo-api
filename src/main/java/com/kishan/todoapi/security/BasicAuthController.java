package com.kishan.todoapi.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicAuthController {
	
	@GetMapping("/basicauth")
	public ResponseEntity<String> authenticateUser() {
		
		return new ResponseEntity<>(
		          "login done", 
		          HttpStatus.OK);
	}

}
