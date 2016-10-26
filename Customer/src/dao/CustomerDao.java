package dao;


import po.Customer;


public interface CustomerDao {

	public Customer addUser(Customer c);
	public Customer loadUser(String id);
	public Customer update(Customer c);
}
