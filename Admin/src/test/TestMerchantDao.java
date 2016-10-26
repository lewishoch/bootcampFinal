package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.MerchantDao;
import po.Merchant;
import po.ShopInfo;
import service.MerchantManager;
import service.impl.MerchantManagerImpl;

public class TestMerchantDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private MerchantDao md = (MerchantDao)context.getBean(MerchantDao.class);
	private MerchantManager mm = (MerchantManager)context.getBean(MerchantManager.class);
	
	
	@Test
	public void testListAllMerchantsByStatus(){
//		List<Merchant> ms = md.listAllMerchantsBySatus(1);
		List<Merchant> ms = mm.findMerchantsByStatus(3);
		for(Merchant m:ms){
			System.out.println(m.getmName());
		}
	}
	
	@Test
	public void testInsertMerchant(){
		ShopInfo s = new ShopInfo();
		s.setsAddr("111111");
		s.setsName("111");
		s.setsTel("1111");
		s.setsLogoPath("1111");
		s.setsCat("111");
		Merchant m = new Merchant();
		m.setUname("test");
		m.setStatus(3);
		m.setmName("hihi3");
		m.setPsd("123");
		m.setmGender("F");
		m.setmAge(100);
		m.setCreDt(new Date());
		m.setLastModDt(new Date());
		m.setShop(s);
//		md.insertMerchant(m);
		
		mm.insertMerchant(m);
	}
	
	@Test
	public void testLoadMerchant(){
		String mid = "8a5e9d35580070ba01580070bd760000";
		Merchant m = mm.findMerchant(mid); 
//				md.loadMerchant(mid);
		System.out.println(m.getmName());
		System.out.println(m.getShop().getsName());
	}
	
	@Test
	public void testUpdateMerchant(){
		String mid = "8a5e9d35580070ba01580070bd760000";
		Merchant m = new Merchant();
		m.setMid(mid);
		m.setStatus(1);
		md.updateMerchant(m);
	}
}
