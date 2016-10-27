package queue.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import po.Advertisement;
import queue.protocal.MerchantMessage;
import queue.protocal.MerchantMessageProcessor;
import service.AdvertisementManager;
import service.MerchantManager;

@Component("mmcm")
public class MerchantMessageConsumer {
	@Autowired
	private AdvertisementManager am;
	
	public void handleMessage(String message) throws Exception{
		System.out.println("---------Consumer---------");
		System.out.println(message);
		MerchantMessage msg = MerchantMessageProcessor.process(message);
		System.out.println(msg);//.getId()+"..."+msg.getAction());
		//mm.updateMerchant();
		Advertisement ad = am.getAdvertisementByWebService(msg.getId());
		if(ad != null){
			am.updateAdvertisement(ad);
		}
			
	}
	
}
