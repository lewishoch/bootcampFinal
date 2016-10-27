package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import service.CustomerManager;

@Controller
@RequestMapping(value="customer")
public class CustomerController {
	
	@Autowired
	private CustomerManager cm;
	
	@RequestMapping(value="loadCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer loadCustomer(String cid) {
		return cm.loadCustomer(cid);
	}

}
