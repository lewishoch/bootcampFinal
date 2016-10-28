package service.impl;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import dao.OrderDao;
import po.Merchant;
import po.Order;
import service.OrderManager;
@Service
public class OrderManagerImpl implements OrderManager{
	@Autowired
	private OrderDao od;
	
	@Override
	@Transactional
	public Order getOrder(String oid) {
		Order o = od.loadOrder(oid);
		Order order = new Order();
		
		order.setComments(o.getComments());
		order.setOid(o.getOid());
		order.setRating(o.getRating());
		order.setStatus(o.getStatus());
		order.setCustomer(o.getCustomer());
		order.setMerchant(o.getMerchant());
		order.setCreDt(o.getCreDt());
		order.setLastModDt(o.getLastModDt());
//		order.setCreDt(new Date());

		return order;
	}

	@Override
	@Transactional
	public void updateOrder(Order o) {
		od.updateOrder(o);
	}

	@Override
	@Transactional
	public List<Order> findAllOrders() {
		List<Order> os = od.findAllOrders();
		return os;
	}

	@Override
	@Transactional
	public void insertOrder(Order o) {
		od.insertOrder(o);
	}

	@Override
	@Transactional
	public Order getOrderByWebService(String oid) {
		String orderString = "";
		Order order = null;
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("oid", oid);
		client.setReadTimeout(1000);
		WebResource wr = client
//				.resource("http://localhost:8081/Admin/getOrder");
				.resource("http://10.222.57.12:8080/Customer/order/getOrder");
		orderString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		
		System.out.println(orderString);
		
		try {
			order = new ObjectMapper().readValue(orderString, Order.class);
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
		return order;
	}

	@Override
	@Transactional
	public void insertAndBlock(Order o) {
//		Order order = od.insertOrder(o);
//		System.out.println(order.getMerchant().getMid());
		long count = od.countOrdersByMerchant(o);
		System.out.println("count: "+count);
	}

	@Override
	@Transactional
	public List<Order> findOrdersByStatus(int status) {
		List<Order> os = od.findOrdersByStatus(status);
		return os;
	}

}
