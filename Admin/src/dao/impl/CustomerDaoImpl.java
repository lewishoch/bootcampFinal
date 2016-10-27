package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.CustomerDao;
import po.Customer;
@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public void insertCustomer(Customer c) {
		em.persist(c);
	}

	@Override
	public Customer loadCustomer(String cid) {
		Customer c = em.find(Customer.class, cid);
		return c;
	}

}
