package producer.util;

import javax.jms.Queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import queue.producer.CustomerQueueProducer;
import queue.producer.MerchantQueueProducer;
import queue.protocal.CustomerMessage;
import queue.protocal.MerchantMessage;

public class CustomerQueueProducerUtil {
private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Transactional
	public static void queue(String id) {
		CustomerQueueProducer cqps = (CustomerQueueProducer) context.getBean("cqps");
		Queue queue= (Queue)context.getBean("customerQueue");
		
		CustomerMessage msgObj = new CustomerMessage();
		msgObj.setId(id);
		
		cqps.sendMessage(queue, msgObj);
	}
}
