package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Customer;
import service.CustomerManager;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AdvertisementManager;


public class Test1 {
	
	@Test
	public void asdf()
	{
		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdvertisementManager m = context.getBean(AdvertisementManager.class);
		
		m.findlastestAdv(5);
		
//		ApplicationContext context  = new ClassPathXmlApplicationContext("applicationContext.xml");
//		AdvertisementManager m = context.getBean(AdvertisementManager.class);
//		m.findlastestAdv(5);
//		
//		
//		Customer c = new Customer();
//		c.setName("hong");
//		c.setPsd("1234");
//		c.setLastModDt(new Date());
//		List<String> addr = new ArrayList<String>();
//			addr.add("address_1");
//			addr.add("address_2");
//			addr.add("address_3");
//		c.setAddress(addr);
//		um.addUser(c);
	}
}
