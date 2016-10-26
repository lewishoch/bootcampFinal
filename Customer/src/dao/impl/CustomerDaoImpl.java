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
	public Customer addCustomer(Customer customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	@Transactional
	public Customer loadCustomer(String id) {
		return em.find(Customer.class, id);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		Customer c = em.getReference(Customer.class, customer.getCid());
		c.setName(customer.getName());
		c.setPsd(customer.getPsd());
		c.setAddress(customer.getAddress());
		c.setLastModDt(customer.getLastModDt());
		return c;
	}



}
