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
@RequestMapping(value="o")
public class OrderController {
	@Autowired
	private OrderManager om;
	
	@RequestMapping("/getOrder")
	@ResponseBody
	public Order getOrder(String id){
		Order o = om.getOrder(id);
		return o;
	}
	
	@RequestMapping("/getAllOrders")
	@ResponseBody
	public List<Order> getAllOrders(){
		List<Order> os = om.findAllOrders();
		return os;
	}
	
	@RequestMapping("/getPendingComplaints")
	@ResponseBody
	public List<Order> getPendingOrders(){
		List<Order> os = om.findOrdersByStatus(Order.UNDER_COMPLAIN);
		return os;
	}
	
	@RequestMapping("/insertOrder")
	@ResponseBody
	public void insertOrder(Order o){
		om.insertOrder(o);
	}
	
	@RequestMapping(value="/updateOrder", method = {RequestMethod.POST})
	@ResponseBody
	public void updateOrder(String oid, int status){
		Order o = new Order();
		o.setOid(oid);
		o.setStatus(status);
		om.updateOrder(o);
	}
}
