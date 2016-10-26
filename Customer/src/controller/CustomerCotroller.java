package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import service.CustomerManager;

@Controller
public class CustomerCotroller {

	@Autowired
	private CustomerManager cm;
	
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
}
