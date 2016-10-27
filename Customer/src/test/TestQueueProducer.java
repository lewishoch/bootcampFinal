package test;

import org.junit.Test;

import producer.util.CustomerQueueProducerUtil;

public class TestQueueProducer {

	@Test
	public void testSendMsg(){
		CustomerQueueProducerUtil.queue("1");
	}
}
