package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import dao.OrderDao;
import po.Merchant;
import po.Order;
import po.OrderedDish;
import service.MerchantManager;

@Repository
public class OrderDaoImpl implements OrderDao {
	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public List<Order> viewAllOrders(HttpServletRequest request) {
		String jpql = "select o from Order o where o.customer.cid =:cid";
		HttpSession sen = request.getSession(); 
		//select * from Orders o, Ordered_Dish od where o.oid = od.oid and o.cid='297e3fc45803dee8015803df5f220000'
		String cid = (String) sen.getAttribute("uuid"); 
		System.out.println("i am "+cid);
		Query q = em.createQuery(jpql).setParameter("cid", cid);
		List<Order> o = q.getResultList();
		Set<OrderedDish> a = o.get(0).getDishes();

			for(OrderedDish aa: a)
		{
			System.out.print("checking -->" + aa.getDish().getDishPrice());
		}
		return o;

	}
	@Override
	public Order updateOrder(Order order) {
		Order o = em.find(Order.class, order.getOid());
		o.setStatus(order.getStatus());
		o.setComments(order.getComments()); 
		o.setRating(order.getRating());
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
	@Override
	public void createOrder(Order order) {
		em.persist(order);
		
	}

	
	

}
