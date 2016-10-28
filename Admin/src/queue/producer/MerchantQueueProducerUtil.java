package queue.producer;

import javax.jms.Queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import queue.producer.MerchantQueueProducer;
import queue.protocal.MerchantMessage;

public class MerchantQueueProducerUtil {
private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Transactional
	public static void queue(int action, String id) {
		MerchantQueueProducer mqps = (MerchantQueueProducer) context.getBean("mqps");
		Queue queue= (Queue)context.getBean("merchantQueue2");
		
		MerchantMessage msgObj = new MerchantMessage();
		msgObj.setAction(action);
		msgObj.setId(id);
		
		mqps.sendMessage(queue, msgObj);
	}
}
