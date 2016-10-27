package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Order;
import service.OrderManager;

public class TestOrder {
	private static ApplicationContext context = null;
	private static OrderManager om = null;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		om = (OrderManager)context.getBean(OrderManager.class);
	}
	
	@Test
	public void TestCountOrdersByMid(){
		Order o = om.getOrder("1");
		om.insertAndBlock(o);
	}
}
