package service;

import java.util.List;

import po.Order;

public interface OrderManager {
	public List<Order> findAllOwnOrders(String mid);
	public List<Order> findAllOwnOrdersByStatus(String mid, Integer status);
	public Order loadOrder(String oid);
	public Order updateOrder(Order o);
}
