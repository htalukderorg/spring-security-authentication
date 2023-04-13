package com.build.lab.model;

import java.util.List;
import java.util.UUID;

import org.springframework.util.Assert;

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

	/**
	 * Builds the user to be added. At minimum the username, password, and
	 * authorities should provided. The remaining attributes have reasonable
	 * defaults.
	 */
	public static final class UserBuilder {

		private String username;

		private String password;

		private List<String> authority;

		private UUID id;

		/**
		 * Creates a new instance
		 */
		public UserBuilder() {
		}

		public UserBuilder id(UUID id) {
			Assert.notNull(id, "username cannot be null");
			this.id = id;
			return this;
		}

		/**
		 * Populates the username. This attribute is required.
		 * 
		 * @param username the username. Cannot be null.
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 *         additional attributes for this user)
		 */
		public UserBuilder username(String username) {
			Assert.notNull(username, "username cannot be null");
			this.username = username;
			return this;
		}

		/**
		 * Populates the password. This attribute is required.
		 * 
		 * @param password the password. Cannot be null.
		 * @return the {@link UserBuilder} for method chaining (i.e. to populate
		 *         additional attributes for this user)
		 */
		public UserBuilder password(String password) {
			Assert.notNull(password, "password cannot be null");
			this.password = password;
			return this;
		}

		public UserBuilder authority(List<String> authority) {
			this.authority = authority;
			return this;
		}

		public AppUser build() {
			return new AppUser(this.id, this.username, this.password, this.authority);
		}

	}
}
