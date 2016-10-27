package service;

import po.Customer;

public interface CustomerManager {
	public void insertCustomer(Customer c);
	public Customer findCustomer(String cid);
}
