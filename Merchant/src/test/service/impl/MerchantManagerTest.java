package test.service.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Merchant;
import po.ShopInfo;
import protocol.AccountStatusProtocol;
import service.MerchantManager;
import util.Constant;

public class MerchantManagerTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@org.junit.Test
	public void testMerchantAdd() {
		MerchantManager mm = context.getBean(MerchantManager.class);
		
		Merchant m = new Merchant();
		m.setUname("group02");
		m.setPsd("02group");
		m.setStatus(AccountStatusProtocol.PENDING);
		m.setmName("clara");
		m.setmAge(50);
		m.setmGender(Constant.FEMALE);
		
		ShopInfo shop = new ShopInfo();
		shop.setsName("group02 shop");
		shop.setsAddr("zhuhai");
		shop.setsCat("no style");
		shop.setsTel("22222222");
		shop.setsLogoPath("/group02");
		
		m.setShop(shop);
		m.setCreDt(new Date());
		m.setLastModDt(new Date());
		
		mm.addMerchant(m);
	}
}
