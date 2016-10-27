package test;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import org.junit.Test;

import po.Order;
import po.OrderedDish;

public class TestWebService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}
	
	
	
	@Test
	public void testGet(){
		Client client = Client.create();
		MultivaluedMap params=new MultivaluedMapImpl();
		params.add("comments", "hello");
		//client.setReadTimeout(1000);
		WebResource wr = client.resource("http://localhost:8080/Customer/history.html");
		String result = wr.queryParams(params).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		System.out.println(result);
		
	}
	
	@Test
	public void testPost() throws Exception{
		Client client = Client.create();
		Form form = new Form();
		form.add("comments", "hi");
		WebResource wr = client.resource("http://localhost:8080/Customer/history.html");
		ClientResponse resp = wr.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
								.accept(MediaType.APPLICATION_JSON_TYPE)
								.post(ClientResponse.class,form);
		
		String s = resp.getEntity(String.class);
		System.out.println(new String(s));
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String url="";
		Client client = Client.create();
		
		WebResource wr= client.resource(url);
		Form form = new Form();
		form.add("customer", "john");
		form.add("merchant", "ben");
		form.add("status", 1);
		form.add("rating", 5);
		form.add("comments","diu");
//		Set<OrderedDish> dish = new HashSet<OrderedDish>();
//		dish.add("noodles");
//		dish.add("cup");
		
		
		ClientResponse resp = wr.post(ClientResponse.class, form);
		String rs = resp.getEntity(String.class);
		System.out.println(rs);
		
		ObjectMapper mapper= new ObjectMapper();
		Order o = mapper.readValue(rs.getBytes(), Order.class);
		System.out.println(o.getMerchant()+"...."+o.getComments());
		
	}
}

