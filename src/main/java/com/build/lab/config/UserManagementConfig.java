package com.build.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.build.lab.services.CustomUserDetailsService;
import com.build.lab.services.UserAccessService;

/*
 * It is a good practice to separate classes based on the responsibility SOLID principle
 */

@Configuration
public class UserManagementConfig {

	private final UserAccessService userAccessService;

	public UserManagementConfig(UserAccessService userAccessService) {
		this.userAccessService = userAccessService;
	}

	/*
	 * If, for any reason, we don't want to encode the configured password, we can
	 * make use of the NoOpPasswordEncoder .password("{noop}password")
	 */

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService(userAccessService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new PlainTextPasswordEncoder();
	}
}
