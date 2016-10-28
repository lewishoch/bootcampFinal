package service.impl;

import java.util.Date;
import java.util.List;




import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import po.Order;
import dao.OrderDao;
import service.OrderManager;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDao od;
	
	@Override
	@Transactional
	public List<Order> viewAllOrder(HttpServletRequest request) {
		return od.viewAllOrders(request);
	}

	@Override
	@Transactional
	public Order updateOrder(Order order) {
		return od.updateOrder(order);
	}

	@Override
	@Transactional
	public Order findOrder(String id) {
		Order o = od.findOrder(id);
		Order order = new Order();
		
		order.setComments(o.getComments());
		order.setOid(o.getOid());
		order.setRating(o.getRating());
		order.setStatus(o.getStatus());
		order.setCustomer(o.getCustomer());
		order.setMerchant(o.getMerchant());
		order.setCreDt(new Date());
	
		return order;
	}

	@Override
	@Transactional
	public void createOrder(Order order) {
		od.createOrder(order);
		
	}

}
