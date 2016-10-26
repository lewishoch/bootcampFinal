package test;

import org.junit.Test;
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
		
		
	}

}
