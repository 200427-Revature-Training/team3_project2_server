package com.team3.interfaceRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team3.models.User;



public interface InterfaceUserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
	Optional<User> findById(Integer id);
	
	Boolean existsByEmail(String email);
}
