package test.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Order;
import po.OrderedDish;
import service.OrderManager;

public class OrderManagerImplTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	OrderManager om = context.getBean(OrderManager.class);

	@org.junit.Test
	public void testOrderFindAllByMid() {
		List<Order> os = om.findAllOwnOrders("8a5e72cb57ffe8b00157ffe8b8900000");
		for (Order o: os) {
			System.out.println("Order:");
			System.out.println(o.getOid()+"..."+o.getCustomer().getName()+"..."+o.getCustomer().getName()+"..."+o.getStatus()+"..."+o.getComments()+"..."+o.getReply());
			for (OrderedDish od: o.getDishes()) {
				System.out.println(od.getOdid()+"..."+od.getQuantity()+"..."+od.getDish().getDid()+"..."+od.getDish().getDishName()+"..."+od.getDish().getDishPhoto()+"..."+od.getDish().getDishPrice());
			}
		}
	}
	
	@org.junit.Test
	public void testOrderFindAllByMidAndStatus() {
		List<Order> os = om.findAllOwnOrdersByStatus("8a5e72cb57ffe8b00157ffe8b8900000", 3);
		for (Order o: os) {
			System.out.println("Order:");
			System.out.println(o.getOid()+"..."+o.getCustomer().getName()+"..."+o.getCustomer().getName()+"..."+o.getStatus()+"..."+o.getComments()+"..."+o.getReply());
			for (OrderedDish od: o.getDishes()) {
				System.out.println(od.getOdid()+"..."+od.getQuantity()+"..."+od.getDish().getDid()+"..."+od.getDish().getDishName()+"..."+od.getDish().getDishPhoto()+"..."+od.getDish().getDishPrice());
			}
		}
	}

	@org.junit.Test
	public void testOrderUpdate() {
		Order o = om.loadOrder("1");
		System.out.println("Original order:");
		System.out.println(o.getOid()+"..."+o.getCustomer().getName()+"..."+o.getCustomer().getName()+"..."+o.getStatus()+"..."+o.getComments()+"..."+o.getReply());
		for (OrderedDish od: o.getDishes()) {
			System.out.println(od.getOdid()+"..."+od.getQuantity()+"..."+od.getDish().getDid()+"..."+od.getDish().getDishName()+"..."+od.getDish().getDishPhoto()+"..."+od.getDish().getDishPrice());
		}
		
		o.setStatus(1);
		om.updateOrder(o);
		
		o = om.loadOrder("1");
		System.out.println("Updated order:");
		System.out.println(o.getOid()+"..."+o.getCustomer().getName()+"..."+o.getCustomer().getName()+"..."+o.getStatus()+"..."+o.getComments()+"..."+o.getReply());
		for (OrderedDish od: o.getDishes()) {
			System.out.println(od.getOdid()+"..."+od.getQuantity()+"..."+od.getDish().getDid()+"..."+od.getDish().getDishName()+"..."+od.getDish().getDishPhoto()+"..."+od.getDish().getDishPrice());
		}
	}
}
