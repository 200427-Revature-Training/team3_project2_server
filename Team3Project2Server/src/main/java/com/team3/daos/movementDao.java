/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.daos;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.team3.Launcher;
import com.team3.models.movement;
import com.team3.models.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

/**
 *
 * @author JJ
 */
public class movementDao {

    SessionFactory sf;
    Logger logger = Logger.getRootLogger();

    public movementDao() {
        super();
        sf = Launcher.getSessionFactory();
    }

    public void insertmovement(movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(move);
            tx.commit();
        }
    }

    public void addApprover(user approver, movement move) {
        if (move.getApprover() == 0) {
            move.setApprover(approver.getId());
        } else if (move.getApprover() != 0) {
            logger.warn("Movement has already been resolved");
            return;
        }

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            move.setApprover(approver.getId());
            move = (movement) session.merge(move);
            tx.commit();
        }
    }


    public movement updateMovement(movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            move = (movement) session.merge(move);
            tx.commit();
            return move;
        }
    }

    public void deleteMovement(movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(move);
            tx.commit();
        }
    }
    
    
    public movement getMovementById(int id) {
		try(Session session = sf.openSession()) {
			// Retrieve associated instance
			movement move = session.get(movement.class, id);
			if (move == null) return null;
			
					
			// Initialize this collection
			Hibernate.initialize(move);
			
			// Return
			return move;
		}
	}

}
