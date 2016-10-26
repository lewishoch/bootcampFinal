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
	public List<Order> viewAllOrders(String cid) {
		String jpql = "select o from Order o, Customer c where o.customer.cid = c.cid and c.cid = :cid";
		Query q = em.createQuery(jpql).setParameter("cid", cid);
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
