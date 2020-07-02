package com.team3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.models.MovementType;
import com.team3.services.MovementTypeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/movementType")
public class MovementTypeController {

	@Autowired
	MovementTypeService movementTypeService;
	/*
	@PostMapping
	public MovementType insertMovementType( @RequestBody MovementType movementType) {
		return movementTypeService.insertMovementType(movementType);
	}
	*/
	@GetMapping("/{id}")
	public MovementType getMovementTypeById(@PathVariable int id) {
		return movementTypeService.getMovementTypeById(id);
	}
        
         @GetMapping("/name/{stat}")
    public MovementType getMovementTypeByName(@PathVariable String stat) {
        return movementTypeService.getMovementTypeByName(stat);
    }
}
