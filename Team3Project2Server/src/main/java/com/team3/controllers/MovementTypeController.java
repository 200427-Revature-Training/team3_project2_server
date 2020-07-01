package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.MovementType;
import com.team3.services.MovementTypeService;

@RestController
@RequestMapping("/movementType")
public class MovementTypeController {

	@Autowired
	MovementTypeService movementTypeService;
	
	@PostMapping
	public MovementType insertMovementType(MovementType movementType) {
		return movementTypeService.insertMovementType(movementType);
	}
	
	@GetMapping("/{id}")
	public MovementType getMovementTypeById(int id) {
		return movementTypeService.getMovementTypeById(id);
	}
}
