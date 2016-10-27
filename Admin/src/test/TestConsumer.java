package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import queue.consumer.CustomerMessageConsumer;
import queue.consumer.MerchantMessageConsumer;

public class TestConsumer {
	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
	
	@Test
	@Transactional
	public void testMerchantQueueConsumer() throws Exception {
		MerchantMessageConsumer mmcm = (MerchantMessageConsumer) context.getBean("mmcm");
		// test for merchant register
//		String message = "{\"id\":\"8a5e72cb580527bb01580527c2190000\",\"action\":1}";
//		String message = "{\"id\":\"2\",\"action\":1}";
		// test for advertisement application
		String message = "{\"id\":\"8a5e72cb5804223a0158042240820000\",\"action\":2}";
		mmcm.handleMessage(message);
	}
	
	@Test
	@Transactional
	public void testCustomerQueueConsumer() throws Exception {
		CustomerMessageConsumer cmcm = (CustomerMessageConsumer) context.getBean("cmcm");
//		String message = "{\"id\":\"8a5e9d35580072db01580072de4b0000\"}";
		String message = "{\"id\":\"1\"}";
		cmcm.handleMessage(message);
	}
}
