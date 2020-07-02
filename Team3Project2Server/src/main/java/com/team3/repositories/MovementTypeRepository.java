package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.MovementType;
import java.util.List;
import org.hibernate.query.Query;

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
        
        public Optional<MovementType> getMovementTypeByName(String type) {
        Session session = eManager.unwrap(Session.class);
        String hql = "FROM MovementType p WHERE p.movementType = :type";
        Query query = session.createQuery(hql, MovementType.class);
        query.setParameter("type", type);
        List<MovementType> m = query.list();
        MovementType[] moves = new MovementType[m.size()];
        m.toArray(moves);
        return Optional.ofNullable(moves[0]);
    }
}
