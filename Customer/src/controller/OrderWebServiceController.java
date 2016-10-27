package controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import org.junit.Test;

import dao.OrderDao;
import po.Order;
import service.OrderManager;
import service.impl.OrderManagerImpl;



@Controller
@RequestMapping(value="order")
public class OrderWebServiceController {

	
	@Autowired
	private OrderManager om;
	
	public void getOrder(){
		Client client = Client.create();
		WebResource wr = client
				.resource("");
		ClientResponse resp=wr
				.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)//Content-Type request header
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(ClientResponse.class);
		String result=resp.getEntity(String.class);
		
		
	}
	
	@RequestMapping("/writeComment")
	@ResponseBody
	public Order giveComment(String oid, String comment) {
		Order order = om.findOrder(oid);
		order.setComments(comment);
		om.updateOrder(order);
		
		return order;
		
	}
	
	@RequestMapping("/getOrder")
	@ResponseBody
	public Order getOrder(String oid) {
		Order order = om.findOrder(oid);
		return order;
		
	}

	
	
	
	
}
