package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import po.Order;


public interface OrderManager {

	public Order updateOrder(Order order);
	public Order findOrder(String id);
	public List<Order> viewAllOrder( HttpServletRequest request);
	public void createOrder (Order order);
}
