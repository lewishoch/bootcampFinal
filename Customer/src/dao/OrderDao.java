package dao;

import java.util.List;

import po.Order;



public interface OrderDao {

	public List<Order> viewAllOrders();
	public Order updateOrder(Order order);
	public Order findOrder(String id);
}
