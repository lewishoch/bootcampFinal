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

import queue.protocal.CustomerMessage;
import queue.protocal.CustomerMessageProcessor;
import queue.protocal.MerchantMessage;
import queue.protocal.MerchantMessageProcessor;

@Component("cqps")
public class CustomerQueueProducer {
	@Resource
	private JmsTemplate jmsTemplate;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(Destination destination, CustomerMessage msgObj) {
		System.out.println("---------------Producer-----------------");
		try {
			jmsTemplate.convertAndSend(destination, CustomerMessageProcessor.construct(msgObj));
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
