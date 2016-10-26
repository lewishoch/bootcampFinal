package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Merchant;
import service.MerchantManager;

@Controller
@RequestMapping(value="m")
public class MerchantController {
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping("/getMerchant")
	@ResponseBody
	public Merchant getMerchant(String id){
		Merchant m = mm.findMerchant(id);
//		System.out.println(m.getmName());
		return m;
	}

}
