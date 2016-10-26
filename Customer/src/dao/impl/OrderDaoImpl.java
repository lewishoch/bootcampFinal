package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.OrderDao;
import po.Merchant;
import po.Order;
import service.MerchantManager;

@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public List<Order> viewAllOrders() {
		String jpql = "select o from Orders o";
		Query q = em.createQuery(jpql);
		List<Order> orders = q.getResultList();
		return orders;
	}

	@Override
	public Order updateOrder(Order order) {
		Order o = em.find(Order.class, order.getOid());
		o.setStatus(order.getStatus());
		o.setComments(order.getComments());
		o.setRating(order.getRating());
		return o;
	}

	
	

}
