package queue.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class CustomerQueueListener implements MessageListener{

	@Override
	public void onMessage(Message message) {
		TextMessage textMsg = (TextMessage) message;
		System.out.println("接收到一个纯文本消�?�");
		try {
			System.out.println("消�?�内容是：" + textMsg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}		
	}

}
