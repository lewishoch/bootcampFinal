package test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Advertisement;
import po.Customer;
import po.Dish;
import po.Merchant;
import po.Order;
import service.CustomerManager;
import service.DishManager;
import service.MerchantManager;
import service.OrderManager;
import service.ShopInfoManager;

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
	CustomerManager cm=context.getBean(CustomerManager.class);
	MerchantManager mm = context.getBean(MerchantManager.class);
	OrderManager om = context.getBean(OrderManager.class);
	AdvertisementManager am = context.getBean(AdvertisementManager.class);
	DishManager dm = context.getBean(DishManager.class);
	ShopInfoManager sm = context.getBean(ShopInfoManager.class);
	
	
	@Test
	public void TestaddCustomer(){	
		
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
	public void TestloadCustomer(){
		Customer c = cm.loadCustomer("1");
		System.out.println(c.getName()+"..."+c.getPsd()+"...."+c.getAddress());
	}
	
	@Test
	public void TestupdateCustomer(){
		
		Customer c = cm.loadCustomer("1");
		c.setName("john");
		c.setPsd("ben");
		List<String> addr = new ArrayList<String>();
			addr.add("address_4");
			addr.add("address_5");
		c.setAddress(addr);
		cm.updateCustomer(c);
	}
	
	@Test
	public void TestloadCustomerByName(){
		
		Customer c = cm.loadCustomerByName("john");
		System.out.println(c.getName()+"..."+c.getPsd()+"...."+c.getAddress());
	}
	
	@Test
	public void TestFindMerchant(){
		
		Merchant m = mm.findMerchant("8a5e72cb57ffe8b00157ffe8b8900000");
		System.out.println(m.getmName()+"...."+m.getStatus());
	}
	
	@Test
	public void TestFindAllMerchant(){
		List<Merchant> m = mm.findAllMerchant();
		for(Merchant a:m){
			System.out.println(a);
		}
	}
	
	@Test
	public void TestViewAllOrder(){
		List<Order> o = om.viewAllOrder();
		for (Order a: o){
			System.out.println(a);
		}
	}
	
	@Test
	public void TestFindOrder(){
		Order o = om.findOrder("2");
		System.out.println(o.getRating()+"..."+o.getComments());
	}
	@Test
	public void TestupdateOrder(){
		Order o = om.findOrder("2");
		o.setComments("delicious");
		o.setRating(5);
		om.updateOrder(o);
	}
	
	@Test
	public void TestFindlastestAdv(){
		List<Advertisement> a = am.findlastestAdv(3);
		for(Advertisement b: a){
			System.out.println(b);
		}
	}
	
	@Test
	public void TestGetAllDishes(){
		Set<Dish> d = dm.getAllDishes("8a5e72cb57ffe8b00157ffe8b8900000");
		for(Dish b: d){
			System.out.println(b);
		}
	}
	
	@Test
	public void TestFindAllDishes(){
		Set<Dish> d = sm.findAllDishes("8a5e72cb57ffe8b00157ffe8b8900000");
		for (Dish a: d){
			System.out.println(d);
		}
	}
	
	@Test
	public void TestFindAllComments(){
		List<Order> o = sm.findAllComments("8a5e72cb57ffe8b00157ffe8b8900000");
		for (Order a: o){
			System.out.println(o);
		}
	}
	
	@Test
	public void TestFindDishesByCategory(){
		List<Dish> d = sm.findDishesByCategory("normal");
		for (Dish a: d){
			System.out.println(d);
		}
	}
	
	@Test
	public void TestLoadShopInfo(){
		List<Merchant> m = sm.loadShopInfo("8a5e72cb57ffe8b00157ffe8b8900000", "22221111");
		for (Merchant a:m){
			System.out.println(a);
		}
	}
	
}
