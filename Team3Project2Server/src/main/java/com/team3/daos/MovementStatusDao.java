package com.team3.daos;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.team3.Launcher;
import com.team3.models.MovementStatus;

/**
 * 
 * @author nmpos
 *
 */
public class MovementStatusDao {
	
	SessionFactory sf;
	Logger logger = Logger.getRootLogger();
	
	public MovementStatusDao() {
		super();
		sf = Launcher.getSessionFactory();
	}
	
	/**
	 * 	Create a new Movement Status
	 */
	public void insertMovementStatus(MovementStatus movementStatus) {
		try (Session session = sf.openSession()){
			Transaction ts = session.beginTransaction();
			session.persist(movementStatus);
			ts.commit();
		}
	}
	
	/**
	 *  Retrieve movement status by ID
	 */
	public MovementStatus getMovementStatusById(int id) {
		try (Session session = sf.openSession()){
			MovementStatus movementStatus = session.get(MovementStatus.class, id);
			if (movementStatus == null) {
				return null;
			}
			Hibernate.initialize(movementStatus);
			return movementStatus;
			}
	}

}
