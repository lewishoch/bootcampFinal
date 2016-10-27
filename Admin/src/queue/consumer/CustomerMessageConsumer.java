package queue.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import po.Customer;
import po.Order;
import queue.protocal.CustomerMessage;
import queue.protocal.CustomerMessageProcessor;
import queue.protocal.MerchantMessage;
import queue.protocal.MerchantMessageProcessor;
import service.CustomerManager;
import service.MerchantManager;
import service.OrderManager;

@Component("cmcm")
public class CustomerMessageConsumer {
	@Autowired
	private OrderManager om;
	@Autowired
	private CustomerManager cm;
	
	public void handleMessage(String message) throws Exception{
		System.out.println("---------Consumer---------");
		System.out.println(message);
		CustomerMessage msg = CustomerMessageProcessor.process(message);
		System.out.println(msg.getId()+"...");
		
		Order o = om.getOrderByWebService(msg.getId());
		if(o != null){
			Customer c = o.getCustomer();
			if(cm.findCustomer(c.getCid()) == null)
				cm.insertCustomer(c);
			om.insertOrder(o);
		}
			
//			om.insertAndBlock(o);
	}
	
}
