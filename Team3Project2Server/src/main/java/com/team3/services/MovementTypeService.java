package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.MovementType;
import com.team3.repositories.MovementTypeRepository;

@Service
public class MovementTypeService {

	@Autowired
	MovementTypeRepository movementTypeRepository;
	
	public MovementType insertMovementType(MovementType movementType) {
		return movementTypeRepository.insertMovementType(movementType);
	}
	
	public MovementType getMovementTypeById(int id) {
		return movementTypeRepository.getMovementTypeById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
}
