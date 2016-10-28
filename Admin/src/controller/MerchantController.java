package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/updateMerchant", method = {RequestMethod.POST})
	@ResponseBody
	public void updateMerchant(String mid, int status){
//		System.out.println(m.getmName());
		Merchant m = new Merchant();
		m.setMid(mid);
		m.setStatus(status);
		mm.updateMerchant(m);
	}
	
	@RequestMapping("/getPendingMerchants")
	@ResponseBody
	public List<Merchant> getPendingMerchants(){
		List<Merchant> ms = mm.findMerchantsByStatus(0); 
		return ms;
	}
	
	@RequestMapping("/getAvailableMerchants")
	@ResponseBody
	public List<Merchant> getAvailableMerchants(){
		List<Merchant> msa = mm.findMerchantsByStatus(1);
		List<Merchant> msb = mm.findMerchantsByStatus(3);
		msa.addAll(msb);
		return msa;
	}

}
