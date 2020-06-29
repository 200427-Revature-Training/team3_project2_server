package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.Movement;

@Repository
public class MovementRepository {

	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	
	public Movement saveMovement(Movement movement) {
	 /*  create method saveMovement */	
		return movement;
	}
	
	/*
	//create method getMovementById 
	public Optional<Movement> getUserById(int id) {
	
		
		
		Movement movement; 
		return Optional.ofNullable(movement);
	}
	*/
}
