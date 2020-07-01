package com.team3;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.team3.daos.UserDao;
import com.team3.models.Movement;
import com.team3.models.MovementType;
import com.team3.models.User;
import com.team3.models.UserRole;

/**
 *
 * @author JJ
 */
public class LauncherServer {

    private static SessionFactory sf;
    private static UserDao userDao;

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    static Logger logger = Logger.getRootLogger();

    /* configuration*/
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
                .addAnnotatedClass(Movement.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserRole.class)
                .addAnnotatedClass(MovementType.class);

        // Use configuration to create serviceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // Use configuration to create sessionFactory, passing in serviceRegistry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static void testRun() {
        UserDao userDao = new UserDao();
        UserRole userRole = new UserRole(1, "admin");
        
      //  User newUser = new User(1, "email@email", "pass", "myFname", "myLname", userRole.getId());
        //User newUser = new User(); 
       // userDao.createUser(newUser);
    }

    public static void main(String[] args) {
        System.out.println(" start ...");
        logger.warn(sf);
        sf = configureHibernate();
        logger.warn(sf);
        logger.info("server side starts here ... ");
        try {
            testRun();
            sf.close();
        } catch (PersistenceException e) {
            e.printStackTrace();
            sf.close();
        }
    }

}
