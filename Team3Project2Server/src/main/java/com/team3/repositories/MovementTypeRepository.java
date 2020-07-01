package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.MovementType;

@Repository
public class MovementTypeRepository {
	
	@Autowired
	EntityManager eManager;
	
	@Transactional
	public MovementType insertMovementType(MovementType movementType) {
		Session session = eManager.unwrap(Session.class);
		session.save(movementType);
		return movementType;
	}
	
	public Optional<MovementType> getMovementTypeById(int id) {
		Session session = eManager.unwrap(Session.class);
		MovementType movementType = session.get(MovementType.class, id);
		return Optional.ofNullable(movementType);
	}
}
