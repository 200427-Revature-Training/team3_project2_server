package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.MovementStatus;

@Repository
public class MovementStatusRepository {
	@Autowired
	EntityManager eManager;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public MovementStatus insertMovementStatus(MovementStatus movementStatus) {
		Session session = eManager.unwrap(Session.class);
		session.save(movementStatus);
		return movementStatus;
	}
	
	public Optional<MovementStatus> getMovementStatusById(int id){
		Session session = eManager.unwrap(Session.class);
		MovementStatus movementStatus = session.get(MovementStatus.class, id);
		return Optional.ofNullable(movementStatus);
	}
	
	

}
