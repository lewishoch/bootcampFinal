package dao;

import java.util.List;

import po.Order;



public interface OrderDao {

	public List<Order> viewAllOrders(String cid);
	public Order updateOrder(Order order);
}
