/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.daos;

import com.team3.LauncherServer;
import com.team3.Launcher;
import com.team3.models.User;
import com.team3.models.UserRole;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.apache.log4j.Logger;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author JJ
 */
public class UserDao {

    SessionFactory sf;
    Logger logger = Logger.getRootLogger();

    public UserDao() {
        super();
        sf = Launcher.getSessionFactory();
    }

    /* Create a user */
    public void createUser(User user) {

        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(user);
            user.setFirstName(" Salem as user");
            tx.commit();
        }
    }

    /* get user by id */
 /*
	public List<User> getBearsByCaveId(int userRoleId) {
		try(Session session = sf.openSession()) {
			// Retrieve associated instance
			UserRole userRole = session.get(UserRole.class, userRoleId);
			if (userRole == null) return null;
			
			// Extract the list of Users
			List <User> users = userRole.getUserRole(); 
			// Initialize this collection
			Hibernate.initialize(users);
			
			// Return
			return users;
		}
	}
     */
 /* Update user */
    public void updateUser(User user) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            User updateUser = session.get(User.class, user.getId());
            user = (User) session.merge(updateUser);
            tx.commit();
        }
    }

    /* Delete user */
    public void deleteUser(User user) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        }
    }

   

}
