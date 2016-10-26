package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import po.User;
import dao.UserDao;

public class UserDaoImpl implements UserDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Transactional
	public User addUser(User u) {
		em.persist(u);
		return u;
	}

	@Transactional
	public User loadUser(String id) {
		return em.find(User.class, id);
	}


	@Transactional
	public User update(User u) {
		// TODO Auto-generated method stub
		return null;
	}



}
