package com.build.lab.model;

import java.util.List;
import java.util.UUID;

public class AppUser {
	private UUID id;
	private String userName;
	private String password;
	private List<String> authority;

	public AppUser() {
		super();
	}

	public AppUser(UUID id, String userName, String password, List<String> authority) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.authority = authority;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getAuthority() {
		return authority;
	}

	public void setAuthority(List<String> authority) {
		this.authority = authority;
	}

}
