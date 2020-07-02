package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.MovementStatus;
import java.util.List;
import org.hibernate.query.Query;

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

    public Optional<MovementStatus> getMovementStatusById(int id) {
        Session session = eManager.unwrap(Session.class);
        MovementStatus movementStatus = session.get(MovementStatus.class, id);
        return Optional.ofNullable(movementStatus);
    }

    public Optional<MovementStatus> getMovementStatusByName(String status) {
        Session session = eManager.unwrap(Session.class);
        String hql = "FROM MovementStatus p WHERE p.movementStatus = :status";
        Query query = session.createQuery(hql, MovementStatus.class);
        query.setParameter("status", status);
        List<MovementStatus> m = query.list();
        MovementStatus[] moves = new MovementStatus[m.size()];
        m.toArray(moves);
        return Optional.ofNullable(moves[0]);
    }

}
