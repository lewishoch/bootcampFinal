package dao;

import java.util.List;

import po.Order;

public interface OrderDao {
	public List<Order> findAllOwnOrders(String mid);
	public List<Order> findAllOwnOrdersByStatus(String mid, Integer status);
	public Order loadOrder(String oid);
	public void updateOrder(Order o);
}
