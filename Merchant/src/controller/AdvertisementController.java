package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import po.Merchant;
import producer.util.MerchantQueueProducerUtil;
import protocal.MerchantMessage;
import protocol.AdvertisementStatusProtocol;
import service.AdvertisementManager;
import service.MerchantManager;

@Controller
@RequestMapping(value="advertisement")
public class AdvertisementController {

	@Autowired
	private AdvertisementManager am;
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="findAllOwnAdvertisements", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Advertisement> findAllOwnAdvertisements(String mid) {
		return am.findAllOwnAdvertisements(mid);
	}
	
	@RequestMapping(value="addAdvertisement", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Advertisement addAdvertisement(String mid) {
		try {
			Advertisement newA = new Advertisement();
			newA.setStatus(AdvertisementStatusProtocol.PENDING);
			newA.setMerchant(mm.loadMerchantById(mid));
			newA.setCreDt(new Date());
			newA.setLastModDt(new Date());
			
			Advertisement aWithId = null;
			//Send Apply Ads message to Admin by Queue
			if ((aWithId = am.addAdvertisement(newA)) != null) {
				MerchantQueueProducerUtil.queue(MerchantMessage.APPLY_ADS, aWithId.getAid());
			}
			
			return aWithId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
