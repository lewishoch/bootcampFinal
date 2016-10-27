package queue.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import queue.protocal.MerchantMessage;
import queue.protocal.MerchantMessageProcessor;

@Component("mqps")
public class MerchantQueueProducer {
	@Resource
	private JmsTemplate jmsTemplate;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(Destination destination, MerchantMessage msgObj) {
//		System.out.println("---------------Producer-----------------");
		try {
			jmsTemplate.convertAndSend(destination, MerchantMessageProcessor.construct(msgObj));
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
