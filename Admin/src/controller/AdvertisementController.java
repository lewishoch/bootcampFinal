package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import queue.producer.MerchantQueueProducer;
import service.AdvertisementManager;

@Controller
@RequestMapping(value="a")
public class AdvertisementController {
	@Autowired
	private AdvertisementManager am;
	
	@RequestMapping("/getAdvertisement")
	@ResponseBody
	public Advertisement getAdvertisement(String id){
		Advertisement a = am.findAd(id);
		
//		System.out.println(a.getMerchant().getmName());
		return a;
	}
	
	@RequestMapping("/getAllAdvertisements")
	@ResponseBody
	public List<Advertisement> getAllAdvertisements(){
		List<Advertisement> as = am.findAllAds();
		return as;
	}
	
	@RequestMapping("/getPendingAdvertisements")
	@ResponseBody
	public List<Advertisement> getPendingAdvertisements(){
		List<Advertisement> as = am.findAdsByStatus(Advertisement.PENDING);
		return as;
	}
	
	@RequestMapping(value="/updateAdvertisment", method = {RequestMethod.POST})
	@ResponseBody
	public void updateAdvertisement(String aid, String status){
		Advertisement a = new Advertisement();
		a.setAid(aid);
		a.setStatus(status);
		am.updateAd(a);
		
//		MerchantQueueProducer
	}
}
