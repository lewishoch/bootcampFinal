package service;

import java.util.List;

import po.Order;

public interface OrderManager {
	public Order getOrder(String oid);
	public void updateOrder(Order o);
	public void insertOrder(Order o);
	public List<Order> findAllOrders();
	public List<Order> findOrdersByStatus(int status);
	public Order getOrderByWebService(String oid);
	public void insertAndBlock(Order o);
}
