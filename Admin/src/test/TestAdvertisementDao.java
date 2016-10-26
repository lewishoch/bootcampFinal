package test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdvertisementDao;
import dao.MerchantDao;
import po.Advertisement;
import po.Merchant;
import po.ShopInfo;
import service.AdvertisementManager;
import service.MerchantManager;

public class TestAdvertisementDao {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private AdvertisementDao ad = (AdvertisementDao)context.getBean(AdvertisementDao.class);
	private MerchantDao md = (MerchantDao)context.getBean(MerchantDao.class);
	private MerchantManager mm = (MerchantManager)context.getBean(MerchantManager.class);
	private AdvertisementManager am = (AdvertisementManager)context.getBean(AdvertisementManager.class);
	
	@Test
	public void testInsertAd(){
//		ShopInfo s = new ShopInfo();
//		s.setsAddr("111111");
//		s.setsName("111");
//		s.setsTel("1111");
//		s.setsLogoPath("1111");
//		s.setsCat("111");
//		Merchant m = new Merchant();
//		m.setUname("test");
//		m.setStatus(3);
//		m.setmName("444");
//		m.setPsd("123");
//		m.setmGender("F");
//		m.setmAge(100);
//		m.setCreDt(new Date());
//		m.setLastModDt(new Date());
//		m.setShop(s);
		
		Merchant m = mm.findMerchant("8a5e9d35580070ba01580070bd760000");
		Advertisement a = new Advertisement();
		a.setMerchant(m);
		a.setStatus("N");
		a.setCreDt(new Date());
		a.setLastModDt(new Date());
		
//		ad.insertAd(a);
		am.insertAd(a);
	}
	
	@Test
	public void testLoadAllAds() throws Exception{
		List<Advertisement> as = am.findAllAds();
		List<Advertisement> as1 = new ArrayList<Advertisement>();
		
		for(Advertisement a:as){
			Advertisement a1 = new Advertisement();
			try {
				BeanUtils.getProperty(a, "merchant");
				BeanUtils.copyProperties(a1, a);
				System.out.println(a1.getMerchant().getmName());
			} catch (Exception e) {
				e.printStackTrace();
			} 		
			as1.add(a1);
		}
	}
}
