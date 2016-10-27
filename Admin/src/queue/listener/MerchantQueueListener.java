package queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import queue.consumer.MerchantMessageConsumer;

public class MerchantQueueListener implements MessageListener{
	@Autowired
	private MerchantMessageConsumer mmcm;
	
	@Override
	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		System.out.println("receiving messages");
		try {
			System.out.println(textMsg.getText());		
			mmcm.handleMessage(textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
