package producer.util;

import javax.jms.Queue;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import producer.MerchantQueueProducer;
import protocal.MerchantMessage;

public class MerchantQueueProducerUtil {
private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Transactional
	public static void queue(int action, String id) {
		MerchantQueueProducer mqps = (MerchantQueueProducer) context.getBean("mqps");
		Queue queue= (Queue)context.getBean("merchantQueue");
		
		MerchantMessage msgObj = new MerchantMessage();
		msgObj.setAction(action);
		msgObj.setId(id);
		
		mqps.sendMessage(queue, msgObj);
	}
}
