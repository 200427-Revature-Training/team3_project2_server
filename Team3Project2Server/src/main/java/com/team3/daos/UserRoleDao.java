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
public class UserRoleDao {

    SessionFactory sf;
    Logger logger = Logger.getRootLogger();

    public UserRoleDao() {
        super();
        sf = Launcher.getSessionFactory();
    }

    /* Create a user */
    public void insertUserRole(UserRole role) {
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(role);
            tx.commit();
        }
    }
    
    public UserRole getUserRoleById(int id) {
        try (Session session = sf.openSession()) {
            // Retrieve associated instance
            UserRole role = session.get(UserRole.class, id);
            if (role == null) {
                return null;
            }

            // Initialize this collection
            Hibernate.initialize(role);

            // Return
            return role;
        }
    }

}
