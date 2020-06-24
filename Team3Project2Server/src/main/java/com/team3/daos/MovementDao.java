/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.daos;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.team3.Launcher;
import com.team3.models.Movement;
import com.team3.models.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author JJ
 */
public class MovementDao {

    SessionFactory sf;
    Logger logger = Logger.getRootLogger();

    public MovementDao() {
        super();
        sf = Launcher.getSessionFactory();
    }

    public void insertMovement(Movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(move);
            tx.commit();
        }
    }

    public void addApprover(User approver, Movement move) {
        if (move.getApprover() == 0) {
            move.setApprover(approver.getId());
        } else if (move.getApprover() != 0) {
            logger.warn("Movement has already been resolved");
            return;
        }

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            move.setApprover(approver.getId());
            move = (Movement) session.merge(move);
            tx.commit();
        }
    }

    public Movement updateMovement(Movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            move = (Movement) session.merge(move);
            tx.commit();
            return move;
        }
    }

    public void deleteMovement(Movement move) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(move);
            tx.commit();
        }
    }

    public Movement getMovementById(int id) {
        try (Session session = sf.openSession()) {
            // Retrieve associated instance
            Movement move = session.get(Movement.class, id);
            if (move == null) {
                return null;
            }

            // Initialize this collection
            Hibernate.initialize(move);

            // Return
            return move;
        }
    }

}
