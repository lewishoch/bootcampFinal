package test.service.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import po.Advertisement;
import producer.util.MerchantQueueProducerUtil;
import protocol.AdvertisementStatusProtocol;
import queue.protocal.MerchantMessage;
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
		Advertisement newA = new Advertisement();
		newA.setMerchant(mm.loadMerchantById("1"));
		newA.setStatus(AdvertisementStatusProtocol.PENDING);
		newA.setCreDt(new Date());
		newA.setLastModDt(new Date());
		
		Advertisement aWithId = null;
		//Send Apply Ads message to Admin by Queue
		if ((aWithId = am.addAdvertisement(newA)) != null) {
			System.out.println(aWithId.getAid());
			MerchantQueueProducerUtil.queue(MerchantMessage.APPLY_ADS, aWithId.getAid());
		}
	}
	
	@org.junit.Test
	public void testAdvertisementFindAllByMid() {
		List<Advertisement> as = am.findAllOwnAdvertisements("8a5e72cb57ffe8b00157ffe8b8900000");
		for (Advertisement a: as) {
			System.out.println(a.getAid()+"..."+a.getMerchant().getUname()+"..."+a.getStatus()+"..."+a.getCreDt()+"..."+a.getLastModDt());
		}
	}
	
}
