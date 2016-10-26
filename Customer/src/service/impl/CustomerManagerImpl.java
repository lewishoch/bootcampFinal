package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CustomerDao;
import po.Customer;
import service.CustomerManager;

@Service
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	private CustomerDao cd;
	
	@Override
	public Customer addUser(Customer c) {
		return cd.addUser(c);
	}

	@Override
	public Customer loadUser(String id) {
		return cd.loadUser(id);
		
	}

	@Override
	public Customer updateUser(Customer c) {
		return cd.updateUser(c);
	}

}
