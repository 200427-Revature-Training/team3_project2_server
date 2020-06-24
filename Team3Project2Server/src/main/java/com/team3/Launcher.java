/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3;

import javax.persistence.PersistenceException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import com.team3.daos.movementDao;
import com.team3.daos.userDao;
import com.team3.models.movement;
import com.team3.models.user;
import java.util.Date;


/**
 *
 * @author JJ
 */
public class Launcher {
<<<<<<< HEAD
    public static void main( String[] args) {
    	System.out.println("start");
		
		
	}
=======

    private static SessionFactory sf;

    private static movementDao movementDao;
    private static userDao userDao;

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    static Logger logger = Logger.getRootLogger();

    /**
     * Loads and augments Hibernate configuration, defines entities, and returns
     * a configured SessionFactory
     */
    static SessionFactory configureHibernate() {
        // Create jdbc url from database URL
        String jdbcUrl = String.format("jdbc:postgresql://%s:5432/postgres",
                System.getenv("NODE_APP_URL"));

        // Create configuration instance
        Configuration configuration = new Configuration()
                .configure()
                .setProperty("hibernate.connection.username", System.getenv("NODE_APP_ROLE"))
                .setProperty("hibernate.connection.url", jdbcUrl)
                .setProperty("hibernate.connection.password", System.getenv("NODE_APP_PASS"))
                .addAnnotatedClass(movement.class)
                .addAnnotatedClass(user.class);

        // Use configuration to create serviceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // Use configuration to create sessionFactory, passing in serviceRegistry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    static void randomMethod() {
        //Note: add user table and make movement model take from that table
        movementDao moveD = new movementDao();
        moveD.insertmovement(new movement(0, 100, new Date(), "Test", 1, 1,1));
        System.out.println(moveD.getMovementById(1));
    }

    public static void main(String[] args) {

        sf = configureHibernate();
        try {

            randomMethod();
            sf.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
            sf.close();

        }
    }
>>>>>>> 776d518002ce2507f4e803925836c929e958851b
}
