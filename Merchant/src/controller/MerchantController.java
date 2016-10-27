package controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import po.Customer;
import po.Dish;
import po.Merchant;
import po.ShopInfo;
import protocol.AccountStatusProtocol;
import protocol.GenderProtocol;
import protocol.ShopCategoryProtocol;
import protocol.ShopStatusProtocol;
import service.MerchantManager;

@Controller
@RequestMapping(value="merchant")
public class MerchantController {
	
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public Merchant login(String uname, String psd, HttpServletRequest request){
		HttpSession sen = request.getSession(true);
		
		Merchant m = mm.loadMerchantByUname(uname);
		
		if(m == null)
		{
			return null;
		}
		
		if(m != null && m.getPsd().equals(psd))
		{
			sen.setAttribute("isLogin", true);
			sen.setAttribute("uuid", m.getMid());
			System.out.println("Login success");
		}
		
		return m;
	}
	
	@RequestMapping(value="/signup", method={RequestMethod.POST})
	@ResponseBody
	public Merchant login(String uname, String psd, String mName, Integer mAge, String sName, String sAddr, String sTel, String sLogoPath)
	{
		Merchant m = mm.loadMerchantByUname(uname);
		
		if(m == null)
		{
			// no existing merchant using the registering name
			Merchant newM = new Merchant();
			newM.setUname(uname);
			newM.setPsd(psd);
			newM.setStatus(AccountStatusProtocol.PENDING);
			newM.setmName(mName);
			newM.setmAge(mAge);
			//newM.setmGender(GenderProtocol.);
			ShopInfo shop = new ShopInfo();
			shop.setsName(sName);
			shop.setsAddr(sAddr);
			shop.setsCat(ShopCategoryProtocol.OTHERS);
			//shop.setsStat(ShopStatusProtocol);
			shop.setsTel(sTel);
			shop.setsLogoPath(sLogoPath);
			newM.setShop(shop);
			newM.setCreDt(new Date());
			newM.setLastModDt(new Date());
			
			return mm.addMerchant(newM);
		}
		else
		{
			// have existing merchant
			return null;
		}
	}
	
	@RequestMapping(value="/logout", method={RequestMethod.GET})
	@ResponseBody
	public void logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		if (session != null)
		    session.invalidate();
	}
	
	@RequestMapping(value="loadMerchantById", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant loadMerchantById(String mid) {
		return mm.loadMerchantById(mid);
	}
	
	@RequestMapping(value="loadMerchantByUname", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant loadMerchantByUname(String uname) {
		return mm.loadMerchantByUname(uname);
	}
	
	@RequestMapping(value="addMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant addMerchant(Merchant m) {
		try {
			return mm.addMerchant(m);
			//return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return "{\"status\":0}";
		}
	}
	
	@RequestMapping(value="updateMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant updateMerchant(Merchant m) {
		try {
			return mm.updateMerchant(m);
			//return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return "{\"status\":0}";
		}
	}
	
	@RequestMapping(value="deleteMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant deleteMerchant(int mid) {
		try {
			return mm.deleteMerchant(mid);
			//return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return "{\"status\":0}";
		}
	}

}
