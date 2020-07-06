package com.team3.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team3.interfaceRepositories.InterfaceUserRepo;
import com.team3.models.User;
import com.team3.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InterfaceUserRepo userRepoInter;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepoInter.findByEmail(email)
				.orElseThrow(() -> 
				new UsernameNotFoundException("User not found with email: " + email));
		
		return UserPrincipal.create(user);
	}

	
	//Changing this method to make it load by email - changed back
	//This method is used by JwtAuthenticationFilter
	//changed parameter type from int to Integer
	@Transactional
	public UserDetails loadUserById(Integer id) {
		User user = userRepoInter.findById(id).orElseThrow(() -> 
				new UsernameNotFoundException("User not found with id: " + id));
		
		return UserPrincipal.create(user);
	}
	
}