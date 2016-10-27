package service.impl;

import java.util.List;






import org.apache.commons.beanutils.BeanUtils;
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
	public List<Order> viewAllOrder(String cid) {
		return od.viewAllOrders(cid);
	}

	@Override
	public Order updateOrder(Order order) {
		return od.updateOrder(order);
	}

	@Override
	public Order findOrder(String id) {
		Order o = od.findOrder(id);
		Order order = new Order();
		
		order.setComments(o.getComments());
		order.setOid(o.getOid());
		order.setRating(o.getRating());
		return order;
	}

}
