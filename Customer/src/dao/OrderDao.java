package dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import po.Order;



public interface OrderDao {

	//public List<Order> viewAllOrders(String cid);
	public Order updateOrder(Order order);
	public Order findOrder(String id);
	public List<Order> viewAllOrders( HttpServletRequest request);
	public void createOrder(Order order);
}
