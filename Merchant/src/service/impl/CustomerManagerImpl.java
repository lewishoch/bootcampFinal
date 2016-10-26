package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import po.Customer;
import service.CustomerManager;

@Service
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	private CustomerDao cd;
	
	@Transactional
	public Customer loadCustomer(String cid) {
		Customer c = cd.loadCustomer(cid);
		c.getAddress().size();
		return c;
	}

}
