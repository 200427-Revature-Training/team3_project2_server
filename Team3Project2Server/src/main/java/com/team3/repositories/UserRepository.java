package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.User;

@Repository
public class UserRepository {
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.MANDATORY)
	public User deleteUser(User user) {
		Session session = em.unwrap(Session.class);
		session.delete(user);
		return user;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User saveUser(User user) {
		Session session = em.unwrap(Session.class);
		session.save(user);
		return user;
	}
	
	public Optional<User> getUserById(int id) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, id);
		return Optional.ofNullable(user);
	}
	
	public Optional<User> getUserByEmail(String email) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, email);
		return Optional.ofNullable(user);
	}

}
