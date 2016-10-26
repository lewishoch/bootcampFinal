package test.service.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Customer;
import po.Dish;
import po.Merchant;
import po.ShopInfo;
import service.DishManager;
import service.MerchantManager;

public class DishManagerImplTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	DishManager dm = context.getBean(DishManager.class);
	MerchantManager mm = context.getBean(MerchantManager.class);
	
	@org.junit.Test
	public void testDishAdd() {
		Dish d = new Dish();
		d.setDishName("Dish1");
		d.setDishPrice(30);
		d.setDishPhoto("/clara/Dish1");
		
		Merchant m = mm.loadMerchantByUname("clara");
		d.setMerchant(m);
		
		dm.addDish(d);
	}
	
	@org.junit.Test
	public void testDishLoadByDid() {
		Dish d = dm.loadDish("8a5e72cb58004d7b0158004d7ff90000");
		if (d != null) {
			System.out.println(d);
			System.out.println(d.getMerchant());
		}
		else
			System.out.println("No such dish");
	}
	
	//Not ok
	@org.junit.Test
	public void testDishLoadByMidAndDname() {
		Dish d = dm.loadDish("8a5e72cb57ffe8b00157ffe8b8900000", "Dish1");
		if (d != null) {
			System.out.println(d);
		}
		else
			System.out.println("No such dish");
	}
	
	@org.junit.Test
	public void testDishDelete() {
		Dish d = dm.loadDish("8a5e72cb580053710158005378440000");
		
		dm.deleteDish(d.getDid());
		
		if (dm.loadDish("8a5e72cb580053710158005378440000") == null)
			System.out.println("Deleted");
	}
}
