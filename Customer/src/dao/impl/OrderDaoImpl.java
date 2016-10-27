package dao.impl;

import java.util.Date;
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
		List<Order> o = q.getResultList();
		return o;

	}
	@Override
	public Order updateOrder(Order order) {
		Order o = em.find(Order.class, order.getOid());
		o.setStatus(order.getStatus());
		o.setComments(order.getComments());
		o.setRating(order.getRating());
		o.setLastModDt(new Date());
		return o;
	}

	@Override
	public Order findOrder(String id) {
		String jpql="select o from Order o where oid =:oid";
		Query q = em.createQuery(jpql);
		q.setParameter("oid", id);
		List<Order> orders = q.getResultList();
		System.out.println(orders.size());
		if(orders.get(0)!=null){
			return orders.get(0);
		} else{
		return null;
		}
	}

	
	

}
