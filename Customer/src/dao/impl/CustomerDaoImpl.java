package dao.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import po.Customer;
import dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	@Transactional
	public Customer addUser(Customer c) {
		em.persist(c);
		return c;
	}

	@Override
	@Transactional
	public Customer loadUser(String id) {
		return em.find(Customer.class, id);
	}


	@Override
	@Transactional
	public Customer updateUser(Customer c) {
		Customer customer = em.getReference(Customer.class, c.getcId());
		return c;
	}



}
