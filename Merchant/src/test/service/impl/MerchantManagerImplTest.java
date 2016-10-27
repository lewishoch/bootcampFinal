package test.service.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Merchant;
import po.ShopInfo;
import producer.util.MerchantQueueProducerUtil;
import protocol.AccountStatusProtocol;
import protocol.GenderProtocol;
import protocol.ShopCategoryProtocol;
import protocol.ShopStatusProtocol;
import queue.protocal.MerchantMessage;
import service.MerchantManager;

public class MerchantManagerImplTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	MerchantManager mm = context.getBean(MerchantManager.class);
	
	@org.junit.Test
	public void testMerchantAdd() {
		Merchant m = new Merchant();
		m.setUname("group02");
		m.setPsd("02group");
		m.setStatus(AccountStatusProtocol.PENDING);
		m.setmName("clara");
		m.setmAge(50);
		m.setmGender(GenderProtocol.FEMALE);
		m.setRating(0);
		m.setNumOfOrder(0);
		
		ShopInfo shop = new ShopInfo();
		shop.setsName("group02 shop");
		shop.setsAddr("zhuhai");
		shop.setsCat("no style");
		shop.setsStat(ShopStatusProtocol.CLOSED);
		shop.setsTel("22222222");
		shop.setsLogoPath("/group02");
		
		m.setShop(shop);
		m.setCreDt(new Date());
		m.setLastModDt(new Date());
		
		if (mm.loadMerchantByUname(m.getUname()) == null) {
			Merchant mWithId = mm.addMerchant(m);
			//Send Register message to  
			if (mWithId != null) {
				System.out.println(mWithId.getMid());
				MerchantQueueProducerUtil.queue(MerchantMessage.REGISTER, mWithId.getMid());
			}
		}
		else
			System.out.println("Merchant name exist already!");
	}
	
	@org.junit.Test
	public void testMerchantLoadById() {
		Merchant m = mm.loadMerchantById("8a5e72cb57ffe8b00157ffe8b8900000");
		if (m != null)
			System.out.println(m.getUname()+"..."+m.getPsd()+"..."+m.getStatus()+"..."+m.getmName()+"..."+m.getmAge()+"..."+m.getmGender()+"..."+m.getShop().getsName()+"..."+m.getShop().getsAddr()+"..."+m.getShop().getsCat()+"..."+m.getShop().getsTel()+"..."+m.getShop().getsLogoPath());
		else
			System.out.println("No such merchant");
	}
	
	@org.junit.Test
	public void testMerchantLoadByUname() {
		Merchant m = mm.loadMerchantByUname("group02");
		if (m != null)
			System.out.println(m.getUname()+"..."+m.getPsd()+"..."+m.getStatus()+"..."+m.getmName()+"..."+m.getmAge()+"..."+m.getmGender()+"..."+m.getShop().getsName()+"..."+m.getShop().getsAddr()+"..."+m.getShop().getsCat()+"..."+m.getShop().getsTel()+"..."+m.getShop().getsLogoPath());
		else
			System.out.println("No such merchant");
	}
	
	@org.junit.Test
	public void testMerchantUpdate() {
		Merchant m = mm.loadMerchantById("8a5e72cb57ffe8b00157ffe8b8900000");
		System.out.println("Original Merchant: "+m.getUname()+"..."+m.getPsd()+"..."+m.getStatus()+"..."+m.getmName()+"..."+m.getmAge()+"..."+m.getmGender()+"..."+m.getShop().getsName()+"..."+m.getShop().getsAddr()+"..."+m.getShop().getsCat()+"..."+m.getShop().getsTel()+"..."+m.getShop().getsLogoPath());
		
		ShopInfo shop = new ShopInfo();
		shop.setsName("group02 shop updated");
		shop.setsAddr("zhuhai updated");
		shop.setsCat("no style updated");
		shop.setsStat(ShopStatusProtocol.OPENED);
		shop.setsTel("22221111");
		shop.setsLogoPath("/group02/new_updated");
		
		m.setShop(shop);
		m.setLastModDt(new Date());
		
		System.out.println(mm.updateMerchant(m));
		
		m = mm.loadMerchantById("8a5e72cb57ffe8b00157ffe8b8900000");
		System.out.println("Updated Merchant: "+m.getUname()+"..."+m.getPsd()+"..."+m.getStatus()+"..."+m.getmName()+"..."+m.getmAge()+"..."+m.getmGender()+"..."+m.getShop().getsName()+"..."+m.getShop().getsAddr()+"..."+m.getShop().getsCat()+"..."+m.getShop().getsTel()+"..."+m.getShop().getsLogoPath());
	}
}
