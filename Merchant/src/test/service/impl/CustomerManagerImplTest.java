package test.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Customer;
import service.CustomerManager;

public class CustomerManagerImplTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	CustomerManager cm = context.getBean(CustomerManager.class);
	
	@org.junit.Test
	public void testCustomerLoad() {
		Customer c = cm.loadCustomer("A");
		if (c != null) {
			System.out.println(c.getCid()+"..."+c.getName()+"..."+c.getPsd()+"..."+c.getCreDt()+"..."+c.getLastModDt());
			for (String a: c.getAddress())
				System.out.println(a);
		}
		else
			System.out.println("No such merchant");
	}
}
