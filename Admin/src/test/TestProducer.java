package test;


import javax.jms.Queue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import producer.MerchantQueueProducer;
import protocal.MerchantMessage;

public class TestProducer {
	private static ApplicationContext context = null;
	
	@BeforeClass
	public static void init() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");

	}
	
	@Test
	@Transactional
	public void testMerchantQueueProducer() {
		MerchantQueueProducer mqps = (MerchantQueueProducer) context.getBean("mqps");
		Queue queue= (Queue)context.getBean("merchentQueue");
		
		MerchantMessage msgObj = new MerchantMessage();
		msgObj.setAction(MerchantMessage.REGISTER);
		msgObj.setId("8a5e9d35580072db01580072de4b0000");
		
		mqps.sendMessage(queue, msgObj);
		
	}

}
