package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Customer;
import service.AdvertisementManager;
import service.CustomerManager;


@Controller
@RequestMapping(value="/user")
public class Test {
	@Autowired
	private AdvertisementManager am;
	@Autowired
	private CustomerManager cm;

	@RequestMapping(value="/test")
	@ResponseBody
	public void getAllUsers(){
		am.findlastestAdv(2);
	}
	
	
	@RequestMapping(value="/test1")
	@ResponseBody
	public Customer loadCustomer(String id){
		return cm.loadCustomer("1");
	}
	
	


}
