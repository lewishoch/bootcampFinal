package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import po.Customer;
import po.Merchant;
import dao.CustomerDao;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	public Customer loadCustomer(String cid) {
		String jpql = "select c from Customer c where c.cid=:cid";
		Customer c = (Customer) em
				.createQuery(jpql)
				.setParameter("cid", cid)
				.getSingleResult();
		return c;
	}

}
