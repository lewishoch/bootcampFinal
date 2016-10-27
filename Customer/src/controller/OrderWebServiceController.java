package controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

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
	
	@ResponseBody
	public void getOrderFromAdmin(String id){
		Client client = Client.create();
		MultivaluedMap params=new MultivaluedMapImpl();
		params.add("id", id);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/o/getOrder");
		String orderString = wr.queryParam("id", id)
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.get(String.class);
		System.out.println(orderString);
		
		try {
			Order order = new ObjectMapper().readValue(orderString, Order.class);
			System.out.println(order.getStatus());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	@Test
	public void testGet() {
		String id = "1";
		Client client = Client.create();
		MultivaluedMap params=new MultivaluedMapImpl();
		params.add("id", id);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/o/getOrder");
		String orderString = wr.queryParam("id", id)
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.get(String.class);
		System.out.println(orderString);
		
		try {
			Order order = new ObjectMapper().readValue(orderString, Order.class);
			System.out.println(order.getStatus());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
