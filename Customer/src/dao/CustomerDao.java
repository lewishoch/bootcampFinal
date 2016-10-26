package dao;


import po.Customer;


public interface CustomerDao {

	public Customer addUser(Customer customer);
	public Customer loadUser(String id);
	public Customer updateUser(Customer customer);
}
