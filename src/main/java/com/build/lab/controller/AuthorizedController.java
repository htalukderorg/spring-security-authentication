package com.build.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/secure")
public class AuthorizedController {
	
	@GetMapping("/hello")
	ResponseEntity<String> sayHelloSecure(){
		return ResponseEntity.ok("Hello from secure API");
	}

}
