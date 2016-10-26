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
	public Customer addCustomer(Customer c) {
		return cd.addCustomer(c);
	}

	@Override
	public Customer loadCustomer(String id) {
		return cd.loadCustomer(id);
		
	}

	@Override
	public Customer updateCustomer(Customer c) {
		return cd.updateCustomer(c);
	}

}
