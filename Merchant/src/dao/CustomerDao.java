package dao;

import po.Customer;

public interface CustomerDao {
	public Customer loadCustomer(String cid);
}
