package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.Movement;
import com.team3.repositories.MovementRepository;
import java.util.List;


@Service
public class MovementService {

	@Autowired
	MovementRepository movementRepository; 
	
	
	public Movement getMovementById(int id) {
		return movementRepository.getMovementById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
        
      public List<Movement> getMovementsByStatus(int id) {
		return movementRepository.getMovementsByStatus(id);
	}
        
      public List<Movement> getMovementsByType(int id) {
		return movementRepository.getMovementsByType(id);
	}
	public List< Movement> getMovements() {
		return movementRepository.getMovements();
	}

	public Movement saveMovement(Movement movement) {
		return movementRepository.saveMovement(movement);
	}
        
        public Movement updateMovement(Movement movement) {
		if(movement.getId() == 0) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST); 
		}
		return movementRepository.updateMovement(movement);
	}
	
}
