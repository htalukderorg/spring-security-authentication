package com.build.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/insecure")
public class NotAuthorizedController {

	@GetMapping("/hello")
	ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hello from insecure API");
	}
}
