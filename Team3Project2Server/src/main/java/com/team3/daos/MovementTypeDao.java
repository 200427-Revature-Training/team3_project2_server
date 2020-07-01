package com.team3.daos;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.team3.Launcher;
import com.team3.models.MovementType;

/**
 * 
 * @author Jared
 * 
 * */
public class MovementTypeDao {

	SessionFactory sf;
	Logger logger = Logger.getRootLogger();
	
	public MovementTypeDao() {
		super();
		sf = Launcher.getSessionFactory();
	}
	
	/**
	 * Create a new Movement Type
	 * */
	public void insertMovementType(MovementType movementType) {
		try (Session session = sf.openSession()) {
			Transaction ts = session.beginTransaction();
			session.persist(movementType);
			ts.commit();
		}
	}
	
	/**
	 * Retrieve movement type by ID
	 * */
	public MovementType getMovementypeById(int id) {
		try(Session session = sf.openSession()) {
			MovementType movementType = session.get(MovementType.class, id);
			if(movementType == null) {
				return null;
			}else {
				Hibernate.initialize(movementType);
				return movementType;
			}
		}
	}
}
