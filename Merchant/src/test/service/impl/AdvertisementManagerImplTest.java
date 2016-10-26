package test.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Advertisement;
import protocol.AdvertisementStatusProtocol;
import service.AdvertisementManager;
import service.MerchantManager;

public class AdvertisementManagerImplTest {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	AdvertisementManager am = context.getBean(AdvertisementManager.class);
	MerchantManager mm = context.getBean(MerchantManager.class);
	
	@org.junit.Test
	public void testAdvertisementAdd() {
		Advertisement a = new Advertisement();
		a.setMerchant(mm.loadMerchantById("8a5e72cb57ffe8b00157ffe8b8900000"));
		a.setStatus(AdvertisementStatusProtocol.PENDING);
		a.setCreDt(new Date());
		a.setLastModDt(new Date());
		am.addAdvertisement(a);
	}
	
	@org.junit.Test
	public void testAdvertisementFindAllByMid() {
		List<Advertisement> as = am.findAllOwnAdvertisements("8a5e72cb57ffe8b00157ffe8b8900000");
		for (Advertisement a: as) {
			System.out.println(a.getAid()+"..."+a.getMerchant().getUname()+"..."+a.getStatus()+"..."+a.getCreDt()+"..."+a.getLastModDt());
		}
	}
}
