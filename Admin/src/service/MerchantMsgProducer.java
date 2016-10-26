package service;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

public interface MerchantMsgProducer {
	public void setJmsTemplate(JmsTemplate jmsTemplate);
	public void sendMessage(Destination destination, final String message);
}
