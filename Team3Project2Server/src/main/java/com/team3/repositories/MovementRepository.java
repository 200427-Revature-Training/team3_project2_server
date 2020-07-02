package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.Movement;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class MovementRepository {

    @Autowired
    EntityManager em;

    @Transactional(propagation = Propagation.REQUIRED)
    public Movement saveMovement(Movement movement) {
        Session session = em.unwrap(Session.class);
        session.save(movement);
        return movement;
    }

    //create method getMovementById 
    public Optional<Movement> getMovementById(int id) {
        Session session = em.unwrap(Session.class);
        Movement movement = session.get(Movement.class, id);
        return Optional.ofNullable(movement);
    }

    public List<Movement> getMovements() {
        Session session = em.unwrap(Session.class);
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Movement> criteria = builder.createQuery(Movement.class);
        criteria.from(Movement.class);
        List<Movement> data = session.createQuery(criteria).getResultList();
        return data;

    }

}
