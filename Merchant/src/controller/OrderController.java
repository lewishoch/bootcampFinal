package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Order;
import service.OrderManager;

@Controller
@RequestMapping(value="order")
public class OrderController {
	
	@Autowired
	private OrderManager om;
	
	@RequestMapping(value="findAllOwnOrders")
	@ResponseBody
	public List<Order> findAllOwnOrders(String mid) {
		return om.findAllOwnOrders(mid);
	}
	
	@RequestMapping(value="findAllOwnOrdersByStatus")
	@ResponseBody
	public List<Order> findAllOwnOrdersByStatus(String mid, Integer status) {
		return om.findAllOwnOrdersByStatus(mid, status);
	}
	
	@RequestMapping(value="loadOrder")
	@ResponseBody
	public Order loadOrder(String oid) {
		return om.loadOrder(oid);
	}
	
	@RequestMapping(value="updateOrder",method={RequestMethod.POST})
	@ResponseBody
	public String updateOrder(Order o) {
		try {
			om.updateOrder(o);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}

}
