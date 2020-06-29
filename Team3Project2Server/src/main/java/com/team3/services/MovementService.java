package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.Movement;
import com.team3.repositories.MovementRepository;

@Service
public class MovementService {

	@Autowired
	MovementRepository movementRepository; 
	
	/*
	public Movement getMovementById(int id) {
		return movementRepository.getMovementById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	*/

	public Movement saveMovement(Movement movement) {
		return movementRepository.saveMovement(movement);
	}
	
}
