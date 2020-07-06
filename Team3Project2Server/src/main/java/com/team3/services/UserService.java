package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.User;
import com.team3.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User deleteUser(User user) {
		if(user.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		return userRepository.deleteUser(user);		 	
	}
	
	public User updateUser(User user) {
		if(user.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST); 
		}
		return saveUser(user);
	}
	
	public User saveUser(User user) {
		return userRepository.saveUser(user);
	}
	
	public User getUserById(int id) {
		return userRepository.getUserById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public User getUserByEmail(String email) {
		return userRepository.getUserByEmail(email)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}

