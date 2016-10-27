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
	@Override
	@Transactional
	public void insertCustomer(Customer c) {
		cd.insertCustomer(c);
	}

	@Override
	@Transactional
	public Customer findCustomer(String cid) {
		Customer c = cd.loadCustomer(cid);
		return c;
	}

}
