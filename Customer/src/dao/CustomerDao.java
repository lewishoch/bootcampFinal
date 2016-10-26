package dao;


import po.Customer;


public interface CustomerDao {

	public Customer addCustomer(Customer customer);
	public Customer loadCustomer(String id);
	public Customer updateCustomer(Customer customer);
	public Customer loadCustomerByName(String uname);
}
