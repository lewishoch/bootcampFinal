package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.OrderDao;
import po.Order;
import service.OrderManager;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDao od;
	
	@Transactional
	public List<Order> findAllOwnOrders(String mid) {
		return od.findAllOwnOrders(mid);
	}

	@Transactional
	public List<Order> findAllOwnOrdersByStatus(String mid, Integer status) {
		return od.findAllOwnOrdersByStatus(mid, status);
	}
	
	@Transactional
	public Order loadOrder(String oid) {
		return od.loadOrder(oid);
	}

	@Transactional
	public void updateOrder(Order o) {
		od.updateOrder(o);
	}

}
