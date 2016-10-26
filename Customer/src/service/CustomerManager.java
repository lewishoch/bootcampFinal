package service;

import po.Customer;

public interface CustomerManager {

	public Customer addCustomer(Customer c);
	public Customer loadCustomer(String id);
	public Customer updateCustomer(Customer c);
	public Customer loadCustomerByName(String uname);
}
