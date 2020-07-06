package com.team3.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignUpRequest {
//Leaving out min and max size restraints for now
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotNull   //changed @NotBlank to @NotNull, @NotBlank is for String types
	private UserRole role;
	

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public UserRole getRole() {
		return role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}	
	
}
