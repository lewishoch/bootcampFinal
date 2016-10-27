package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.OrderDao;
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

	@Override
	public Order loadOrder(String oid) {
		Order order = em.find(Order.class, oid);
		return order;
	}

	@Override
	public List<Order> findAllOrders() {
		String jpql="select o from Order o";
		List<Order> os = em
				.createQuery(jpql)
//				.setParameter("status", status)
				.getResultList();
		return os;
	}

	@Override
	public int countOrdersByMerchant(Order o) {
		String mid = o.getMerchant().getMid();
		String jpql = "select count(o) from Order o where o.mid =:mid";
		int count = (int)em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.getSingleResult();
		
		return count;
	}

}
