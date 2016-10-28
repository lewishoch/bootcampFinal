package dao;

import java.util.List;

import po.Order;

public interface OrderDao {
	public Order insertOrder(Order o);
	public void updateOrder(Order o);
	public Order loadOrder(String oid);
	public List<Order> findAllOrders();
	public List<Order> findOrdersByStatus(int status);
	public long countOrdersByMerchant(Order o);
}
