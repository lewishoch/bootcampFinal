package service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import service.MerchantMsgProducer;
@Component("mmp")
public class MerchantMsgProducerImpl implements MerchantMsgProducer {
	@Resource
	private JmsTemplate jmsTemplate;
	
	@Override
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public void sendMessage(Destination destination, String message) {
		System.out.println("---------------生产者发送消息-----------------");
		System.out.println("---------------生产者发了一个消息：" + message);
		jmsTemplate.send(destination, new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {

				TextMessage textMessage = session.createTextMessage(message);

				return textMessage;

			}
		});
	}

}
