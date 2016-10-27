package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import service.AdvertisementManager;

@Controller
@RequestMapping(value="advertisement")
public class AdvertisementController {

	@Autowired
	private AdvertisementManager am;
	
	@RequestMapping(value="findAllOwnAdvertisements", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Advertisement> findAllOwnAdvertisements(String mid) {
		return am.findAllOwnAdvertisements(mid);
	}
	
	@RequestMapping(value="addAdvertisement", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Advertisement addAdvertisement(Advertisement a) {
		try {
			return am.addAdvertisement(a);
			//return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return "{\"status\":0}";
		}
	}
	
}
