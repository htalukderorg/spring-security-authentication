package com.build.lab.model;

import org.springframework.security.core.GrantedAuthority;

public class MyAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	private String authority;
		
	public MyAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
