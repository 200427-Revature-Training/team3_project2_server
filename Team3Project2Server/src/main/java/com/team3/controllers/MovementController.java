package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.Movement;
import com.team3.services.MovementService;

@RestController
@RequestMapping("/movement")
public class MovementController {
	
	@Autowired
	MovementService movementService; 
	
	
	// get movement by Id
	@GetMapping("/{id}")
	public Movement getUserById(@PathVariable int id) {
		return movementService.getMovementById(id);
	}
	
	
	/* save movement*/
	@PostMapping
	public Movement saveMovement(@RequestBody Movement movement) {
		return movementService.saveMovement(movement);
	}
	
	
	
}
