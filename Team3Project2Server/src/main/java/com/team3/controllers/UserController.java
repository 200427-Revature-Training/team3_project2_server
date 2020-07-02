package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.User;
import com.team3.services.UserService;

@RestController
	@RequestMapping("/user")
public class UserController {

		@Autowired
		UserService userService;
		
		// DELETE user
		@DeleteMapping
		void deleteUser(@RequestBody User user) {
	        userService.deleteUser(user);
	    }
		
		// UPDATE current user
		@PutMapping
		public User updateUser(@RequestBody User user) {
			return userService.updateUser(user);
		}

		// POST new user
		@PostMapping
		public User saveUser(@RequestBody User user) {
			return userService.saveUser(user);
		}
		
		// GET user by ID
		@GetMapping("/{id}")
		public User getUserById(@PathVariable int id) {
			return userService.getUserById(id);
		}
		
		
		
	}
