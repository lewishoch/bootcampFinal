package controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import po.Dish;
import po.Merchant;
import po.ShopInfo;
import producer.util.MerchantQueueProducerUtil;
import protocol.AdvertisementStatusProtocol;
import queue.protocal.MerchantMessage;
import service.AdvertisementManager;
import service.MerchantManager;

@Controller
public class AdvertisementController {

	@Autowired
	private AdvertisementManager am;
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="findAllOwnAdvertisements", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Advertisement> findAllOwnAdvertisements(HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return am.findAllOwnAdvertisements(mid);
		}
		return null;
	}
	
	@RequestMapping(value="addAdvertisement", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Advertisement addAdvertisement(HttpServletRequest request,HttpServletResponse resp) {
		try {
			HttpSession s = request.getSession();
			String mid;
			if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
			{
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
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@RequestMapping(value="getAdvertisement", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Advertisement loadAdvertisement(String aid) {
		return am.loadAdvertisement(aid);
	}
	
}
