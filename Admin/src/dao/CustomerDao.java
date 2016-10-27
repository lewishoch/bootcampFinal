package dao;

import po.Customer;

public interface CustomerDao {
	public void insertCustomer(Customer c);
	public Customer loadCustomer(String cid);

}
