package service.impl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import po.Order;
import dao.OrderDao;
import service.OrderManager;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDao od;
	
	@Override
	public List<Order> viewAllOrder() {
		return od.viewAllOrders();
	}

	@Override
	public Order updateOrder(Order order) {
		return od.updateOrder(order);
	}

}
