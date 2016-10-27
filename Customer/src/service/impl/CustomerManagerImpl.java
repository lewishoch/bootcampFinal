package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import po.Customer;
import service.CustomerManager;

@Service
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	private CustomerDao cd;
	
	@Override
	@Transactional
	public Customer addCustomer(Customer c) {
		return cd.addCustomer(c);
	}

	@Override
	@Transactional
	public Customer loadCustomer(String id) {
		return cd.loadCustomer(id);
		
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer c) {
		return cd.updateCustomer(c);
	}

	@Override
	@Transactional
	public Customer loadCustomerByName(String uname) {
		Customer c = cd.loadCustomerByName(uname);
		if(c != null)
			c.getAddress().size();
		return c;
	}


}
