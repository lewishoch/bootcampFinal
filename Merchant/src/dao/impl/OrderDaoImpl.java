package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import po.Order;
import protocol.OrderStatusProtocol;
import dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	public List<Order> findAllOwnOrders(String mid) {
		String jpql = "select o from Order o where o.merchant.mid=:mid";
		
		List<Order> os = em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.getResultList();
		
		return os;
	}

	public List<Order> findAllOwnOrdersByStatus(String mid, Integer status) {
		String jpql = "select o from Order o where o.merchant.mid=:mid and o.status=:status";
		
		List<Order> os = em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.setParameter("status", status)
				.getResultList();
		
		return os;
	}
	
	public Order loadOrder(String oid) {
		return em.find(Order.class, oid);
	}

	public Order updateOrder(String oid) {
		Order newO = em.find(Order.class, oid);
		
		if (newO.getStatus()==OrderStatusProtocol.PENDING)
			newO.setStatus(OrderStatusProtocol.ACCEPTED);
		else if (newO.getStatus()==OrderStatusProtocol.ACCEPTED)
			newO.setStatus(OrderStatusProtocol.START_DELIVERY);
		else if (newO.getStatus()==OrderStatusProtocol.START_DELIVERY)
			newO.setStatus(OrderStatusProtocol.RECEIVED);
		newO.setLastModDt(new Date());
		
		return newO;
	}

}
