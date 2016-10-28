package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Order;
import service.OrderManager;

@Controller
public class OrderController {
	
	@Autowired
	private OrderManager om;
	
	@RequestMapping(value="findAllOwnOrders", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Order> findAllOwnOrders(HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return om.findAllOwnOrders(mid);
		}
		return null;
	}
	
	@RequestMapping(value="findAllOwnOrdersByStatus", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Order> findAllOwnOrdersByStatus(Integer status, HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return om.findAllOwnOrdersByStatus(mid, status);
		}
		return null;
	}
	
	@RequestMapping(value="loadOrder", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Order loadOrder(String oid) {
		return om.loadOrder(oid);
	}
	
	@RequestMapping(value="updateOrder", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Order updateOrder(Order o) {
		try {
			return om.updateOrder(o);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
