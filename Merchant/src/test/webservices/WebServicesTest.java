package test.webservices;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.Test;

import po.Advertisement;
import po.Merchant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WebServicesTest {
	
	@Test
	public void testMerchantGetMerchant() throws Exception{
		String url = "http://localhost:8080/Merchant/merchant/getMerchant";
		Client client = Client.create();
		WebResource wr = client.resource(url);
		
		Form form=new Form();
		form.add("mid", "8a5e72cb58042b9b0158042ba35f0000");
		
		ClientResponse resp=wr.post(ClientResponse.class,form);
		
		String rs = resp.getEntity(String.class);
		System.out.println(rs);
		
		ObjectMapper mapper = new ObjectMapper();
		Merchant m = mapper.readValue(rs.getBytes(), Merchant.class);
		System.out.println(m.getUname()+"..."+m.getShop().getsName());
	}
	
	@Test
	public void testMerchantGetAds() throws Exception{
		String advertisementString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", "1");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.242.9:8080/Merchant/merchant/getMerchant");
		advertisementString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(advertisementString);
//		String url = "http://localhost:8080/Merchant/advertisement/getAdvertisement";
//		Client client = Client.create();
//		WebResource wr = client.resource(url);
//		
//		Form form=new Form();
//		form.add("aid", "8a5e72cb58041bf90158041bffc00000");
//		
//		ClientResponse resp=wr.post(ClientResponse.class,form);
//		
//		String rs = resp.getEntity(String.class);
//		System.out.println(rs);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		Advertisement a = mapper.readValue(rs.getBytes(), Advertisement.class);
//		System.out.println(a.getMerchant().getmName()+"..."+a.getStatus());
	}
	
	@Test
	public void testAdminGetMerchant() throws Exception{
		String url = "http://:8080/m/getMerchant";
		Client client = Client.create();
		WebResource wr = client.resource(url);
		
		Form form=new Form();
		form.add("id", "1");
		
		ClientResponse resp=wr.post(ClientResponse.class,form);
		
		String rs = resp.getEntity(String.class);
		System.out.println(rs);
		
		ObjectMapper mapper = new ObjectMapper();
		Merchant m = mapper.readValue(rs.getBytes(), Merchant.class);
		System.out.println(m.getUname()+"..."+m.getShop().getsName());
	}
	
	@Test
	public void testAdminGetAds() throws Exception{
//		String url = "http://:8080/A/getAdvertisement";
//		Client client = Client.create();
//		WebResource wr = client.resource(url);
//		
//		Form form=new Form();
//		form.add("aid", "1");
//		
//		ClientResponse resp=wr.post(ClientResponse.class,form);
//		
//		String rs = resp.getEntity(String.class);
//		System.out.println(rs);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		Advertisement a = mapper.readValue(rs.getBytes(), Advertisement.class);
//		System.out.println(a.getMerchant().getmName()+"..."+a.getStatus());
		
		String advertisementString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", "1");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/a/getAdvertisement");
		advertisementString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(advertisementString);
	}
}
