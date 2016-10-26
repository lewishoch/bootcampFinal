package service;

import po.Customer;

public interface CustomerManager {

	public Customer addUser(Customer c);
	public Customer loadUser(String id);
	public Customer updateUser(Customer c);
}
