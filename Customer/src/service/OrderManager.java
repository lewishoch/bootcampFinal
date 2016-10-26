package service;

import java.util.List;

import po.Order;


public interface OrderManager {

	public List<Order> viewAllOrder(String cid);
	public Order updateOrder(Order order);
}
