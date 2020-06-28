package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.UserRole;
import com.team3.services.UserRoleService;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	UserRoleService urService;

	
	
	// GET food by ID
	@GetMapping("/{id}")
	public UserRole getUserRoleById(@PathVariable int id) {
		return urService.getUserRoleById(id);
	}
	
}
