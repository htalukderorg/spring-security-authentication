package com.build.lab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/*
 * It is a good practice to separate classes based on the responsibility SOLID principle
 */

@Configuration
public class UserManagementConfig {

	/*
	 * If, for any reason, we don't want to encode the configured password, we can make use of the
	 * NoOpPasswordEncoder .password("{noop}password")
	 */
	
	@Bean
	public UserDetailsService userDetailsService() {
		var userDetailsService = new InMemoryUserDetailsManager();

		var user = User
				.withUsername("abhik")
				.password("{noop}jaysen")
				.authorities("read")
				.build();

		userDetailsService.createUser(user);

		return userDetailsService;
	}
}
