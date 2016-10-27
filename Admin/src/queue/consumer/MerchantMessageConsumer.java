package queue.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import po.Advertisement;
import po.Merchant;
import queue.protocal.MerchantMessage;
import queue.protocal.MerchantMessageProcessor;
import service.AdvertisementManager;
import service.MerchantManager;

@Component("mmcm")
public class MerchantMessageConsumer {
	@Autowired
	private MerchantManager mm;
	@Autowired
	private AdvertisementManager am;
	
	public void handleMessage(String message) throws Exception{
		System.out.println("---------Merchant Message Consumer---------");
		System.out.println(message);
		MerchantMessage msg = MerchantMessageProcessor.process(message);
		System.out.println(msg.getId()+"..."+msg.getAction());
		if(msg.getAction() == MerchantMessage.REGISTER){
			System.out.println("test1");
			Merchant merchant = mm.getMerchantByWebService(msg.getId());
			System.out.println(merchant.getmName());
			if(merchant != null)
				mm.insertMerchant(merchant);
		} else{
			Advertisement ad = am.getAdvertisementByWebService(msg.getId());
			System.out.println(ad.getMerchant().getmName());
			if(ad != null)
				am.insertAd(ad);
		}
	}
	
}
