package dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import po.Customer;
import dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Transactional
	public Customer addUser(Customer c) {
		em.persist(c);
		return c;
	}

	@Transactional
	public Customer loadUser(String id) {
		return em.find(Customer.class, id);
	}


	@Transactional
	public Customer update(Customer c) {
		Customer customer = em.getReference(Customer.class, c.getcId());
		return c;
	}



}
