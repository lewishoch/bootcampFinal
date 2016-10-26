package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Merchant;
import service.MerchantManager;

@Controller
@RequestMapping(value="merchant")
public class MerchantController {
	
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="loadMerchantById")
	@ResponseBody
	public Merchant loadMerchantById(String mid) {
		return mm.loadMerchantById(mid);
	}
	
	@RequestMapping(value="loadMerchantByUname")
	@ResponseBody
	public Merchant loadMerchantByUname(String uname) {
		return mm.loadMerchantByUname(uname);
	}
	
	@RequestMapping(value="addMerchant",method={RequestMethod.POST})
	@ResponseBody
	public String addMerchant(Merchant m) {
		try {
			mm.addMerchant(m);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}
	
	@RequestMapping(value="updateMerchant",method={RequestMethod.POST})
	@ResponseBody
	public String updateMerchant(Merchant m) {
		try {
			mm.updateMerchant(m);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}
	
	@RequestMapping(value="deleteMerchant",method={RequestMethod.POST})
	@ResponseBody
	public String deleteMerchant(int mid) {
		try {
			mm.deleteMerchant(mid);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}

}
