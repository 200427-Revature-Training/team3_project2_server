package com.team3.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.team3.models.UserRole;



@Repository
public class UserRoleRepository {
	
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	
	public Optional<UserRole> getUserRoleById(int id) {
		Session session = em.unwrap(Session.class);
		UserRole ur = session.get(UserRole.class, id);
		return Optional.ofNullable(ur);
	}
}
