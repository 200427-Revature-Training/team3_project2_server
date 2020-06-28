package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.UserRole;
import com.team3.repositories.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Autowired
	UserRoleRepository urRepository;

	
	
	public UserRole getUserRoleById(int id) {
		return urRepository.getUserRoleById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}
