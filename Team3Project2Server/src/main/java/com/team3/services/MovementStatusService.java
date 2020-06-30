package com.team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.team3.models.MovementStatus;
import com.team3.repositories.MovementStatusRepository;

@Service
public class MovementStatusService {

	@Autowired
	MovementStatusRepository movementStatusRepository;
	
	public MovementStatus insertMovementStatus(MovementStatus movementStatus) {
		return movementStatusRepository.insertMovementStatus(movementStatus);
	}
	
	public MovementStatus getMovementStatusById(int id) {
		return movementStatusRepository.getMovementStatusById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
}
