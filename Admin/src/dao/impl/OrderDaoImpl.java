package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.OrderDao;
import po.Merchant;
import po.Order;
@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Order insertOrder(Order o) {
		em.persist(o);
		return o;
	}

	@Override
	public void updateOrder(Order o) {
		Order order = em.find(Order.class, o.getOid());
		order.setStatus(o.getStatus());
	}

	public Order loadOrder(String oid) {
		Order order = em.find(Order.class, oid);
		return order;
	}

	public List<Order> findAllOrders() {
		String jpql="select o from Order o";
		List<Order> os = em
				.createQuery(jpql)
//				.setParameter("status", status)
				.getResultList();
		return os;
	}

	@Override
	public long countOrdersByMerchant(Order o) {
		Merchant merchant = o.getMerchant();
//		String mid = "2";
		String jpql = "select count(o) from Order o where o.merchant =:merchant";
		long count = (long) em
				.createQuery(jpql)
				.setParameter("merchant", merchant)
				.getSingleResult();
		
		return count;
	}

}
