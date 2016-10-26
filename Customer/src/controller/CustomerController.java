package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import po.Merchant;
import service.AdvertisementManager;
import service.CustomerManager;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private AdvertisementManager am;
	@Autowired
	private CustomerManager cm;
	
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public Customer getAllUsers(String uname, String psd, HttpServletRequest request){
		System.out.println("hello" + uname + ":" + psd );
		HttpSession sen = request.getSession(true);
		
		Customer c = cm.loadCustomerByName(uname);
		
		if(c== null)
		{
			return null;
		}
		
		if(c != null && c.getPsd().equals(psd))
		{
			sen.setAttribute("isLogin", true);
			sen.setAttribute("uuid", c.getCid());
			System.out.println("Login success");
			return c;
		}
		
		return c;
	}
	
	@RequestMapping(value="addCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer addCustomer(Customer c){
	System.out.println("adding customer!!!!!");
	return cm.addCustomer(c);
	}

	@RequestMapping(value="loadCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer loadCustomer(String id){
	System.out.println("loading customer!!!!!!!");
	return cm.loadCustomer(id);
	}

	@RequestMapping(value="updateCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer updatCustomer(Customer c){
	System.out.println("updating customer!!!!!!!");
	return cm.updateCustomer(c);
	}
	
	@RequestMapping(value="findMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant findMerchant(String id){
	System.out.println("finding a merchant...");
	return mm.findMerchant(id);
	}

	@RequestMapping(value="findAllMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Merchant> findAllMerchant(){
	System.out.println("finding all merchants...");
	return mm.findAllMerchant();
	}

}