package test;

import javax.jms.Queue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import queue.consumer.MerchantMessageConsumer;
import queue.producer.MerchantQueueProducer;
import queue.protocal.MerchantMessage;

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
//		Queue queue= (Queue)context.getBean("merchantQueue");
		String message = "{\"id\":\"8a5e9d35580072db01580072de4b0000\",\"action\":1}";
		mmcm.handleMessage(message);
	}
}
