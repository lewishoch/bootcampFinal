package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Customer;
import service.CustomerManager;
import service.MerchantManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDao;
import service.AdvertisementManager;


public class Test1 {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Autowired
	private CustomerDao cd;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void asdf()
	{
		MerchantManager m = context.getBean(MerchantManager.class);
		
		m.findAllMerchant();
		
		
		
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
	@Test
	public void Test1(){
		
		CustomerManager cm=context.getBean(CustomerManager.class);
		
		Customer c = new Customer();
		c.setName("hong");
		c.setPsd("1234");
		c.setLastModDt(new Date());
		List<String> addr = new ArrayList<String>();
			addr.add("address_1");
			addr.add("address_2");
			addr.add("address_3");
		c.setAddress(addr);
		cm.addCustomer(c);
	}
	
	@Test
	public void Testload(){
		
		CustomerManager cm=context.getBean(CustomerManager.class);
		//Customer c1 = cd.loadCustomer("8a5eb98c57ffa5b90157ffa5c3d90000");
		//Customer c = em.find(Customer.class, "hong");
		//System.out.println(c1.getName()+"..."+c1.getPsd()+"...."+c1.getAddress());
		
		
	}
}
