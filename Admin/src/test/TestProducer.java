package test;


import javax.jms.Queue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import queue.producer.CustomerQueueProducer;
import queue.producer.MerchantQueueProducer;
import queue.protocal.CustomerMessage;
import queue.protocal.MerchantMessage;

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
		Queue queue= (Queue)context.getBean("merchantQueue2");
		
		MerchantMessage msgObj = new MerchantMessage();
//		msgObj.setAction(MerchantMessage.REGISTER);
//		msgObj.setId("8a5e9d35580072db01580072de4b0000");
		msgObj.setAction(MerchantMessage.APPLY_ADS);
		msgObj.setId("8a5e9d3558007c6b0158007c6e9a0000");
		mqps.sendMessage(queue, msgObj);
		
	}
	
	@Test
	@Transactional
	public void testCustomerQueueProducer() {
		CustomerQueueProducer cqps = (CustomerQueueProducer) context.getBean("cqps");
		Queue queue= (Queue)context.getBean("customerQueue");
		
		CustomerMessage msgObj = new CustomerMessage();
//		msgObj.setAction(MerchantMessage.REGISTER);
		msgObj.setId("8a5e9d35580072db01580072de4b0000");
		
		cqps.sendMessage(queue, msgObj);
		
	}

}
