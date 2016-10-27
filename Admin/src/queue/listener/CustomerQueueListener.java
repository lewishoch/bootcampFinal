package queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import queue.consumer.CustomerMessageConsumer;

public class CustomerQueueListener implements MessageListener{
	@Autowired
	private CustomerMessageConsumer cmcm;
	@Override
	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		System.out.println("receiving messages from customer queue");
		try {
			System.out.println(textMsg.getText());
			cmcm.handleMessage(textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
