package producer;

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

import protocal.CustomerMessage;
import protocal.CustomerMessageProcessor;
import protocal.MerchantMessage;
import protocal.MerchantMessageProcessor;

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
