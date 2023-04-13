package com.build.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.build.lab.model.AppUser;
import com.build.lab.model.MyAuthority;

public class CustomUserDetailsService implements UserDetailsService {

	private final UserAccessService userAccessService;

	public CustomUserDetailsService(UserAccessService userAccessService) {
		super();
		this.userAccessService = userAccessService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> userfound = this.userAccessService.getUserByUserName(username);
		AppUser user = userfound.orElseThrow(() -> new UsernameNotFoundException("User not found in database"));

		List<MyAuthority> authority = user
										.getAuthority()
										.stream()
										.map(auth -> new MyAuthority(auth))
										.toList();

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authority);
	}

}
