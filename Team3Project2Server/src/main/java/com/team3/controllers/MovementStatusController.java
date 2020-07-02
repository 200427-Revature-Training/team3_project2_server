package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.MovementStatus;
import com.team3.services.MovementStatusService;

@RestController
@RequestMapping("/movementStatus")
public class MovementStatusController {
	
	@Autowired
	MovementStatusService movementStatusService;
	/*
	// POST  a new movement status
	@PostMapping
	public MovementStatus insertMovementStatus(@RequestBody MovementStatus movementStatus) {
		return movementStatusService.insertMovementStatus(movementStatus);
	}
	*/
	// GET movement status by ID
	@GetMapping("/{id}")
	public MovementStatus getMovementStatusById(@PathVariable int id) {
		return movementStatusService.getMovementStatusById(id);
	}

}
