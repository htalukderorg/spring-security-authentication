package com.build.lab.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.build.lab.model.AppUser;

@Service
public class UserAccessService {

	public List<AppUser> getAllUser(){
		return IntStream.rangeClosed(1, 100)
				.mapToObj(i -> new AppUser
					.UserBuilder()
					.id(UUID.randomUUID())
					.username("user" + String.valueOf(i))
					.password("pass" + String.valueOf(i))
					.authority(List.of("user"))
					.build())
					.collect(Collectors.toList());
			
	}
	
	public Optional<AppUser> getUserByUserName(String username) {
		
		return getAllUser()
				.stream()
				.filter(user -> user.getUserName().equalsIgnoreCase(username))
				.findFirst();
	}
}
