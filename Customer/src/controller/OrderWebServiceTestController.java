package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Order;
//provide web service
@Controller
@RequestMapping("orderTest")
public class OrderWebServiceTestController {
	
	
	@RequestMapping("getOrder")
	@ResponseBody
	public Order getOrder() {
		
		Order o = new Order();
		o.setComments("goof order");
		return o;
	} 
	
}
