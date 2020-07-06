package com.team3.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team3.models.User;
import com.team3.models.UserRole;

public class UserPrincipal implements UserDetails {

	private Integer id;
	private String email;
	@JsonIgnore
	private String password;
	private String firstName;
	private String lastName;
	private UserRole role;
	
	
	public UserPrincipal(Integer id, String email, String password, String firstName, String lastName, UserRole role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;;
	}
	
	
	public static UserPrincipal create(User user) {
		return new UserPrincipal(
				user.getId(),
				user.getEmail(),
				user.getPassword(),
				user.getFirstName(),
				user.getLastName(),
				user.getUserRoleId());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		//return null;
		return new HashSet<GrantedAuthority>();
	}
	
	
	public Integer getId() {
		return id;
	}
	
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
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

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		UserPrincipal that = (UserPrincipal) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
}
