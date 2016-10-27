package test.webservices;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.junit.Test;

import po.Advertisement;
import po.Merchant;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class WebServicesTest {
	
	@Test
	public void testMerchantGetMerchant() throws Exception{
		String merchantString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("mid", "2");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.242.75:8080/Merchant/getMerchant");
		merchantString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(merchantString);
	}
	
	@Test
	public void testMerchantGetAds() throws Exception{
		String advertisementString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("aid", "8a5e72cb58054a880158054a8d860000");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.242.75:8080/Merchant/getAdvertisement");
		advertisementString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(advertisementString);
	}
	
	@Test
	public void testAdminGetMerchant() throws Exception{
		String merchantString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", "1");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/m/getMerchant");
		merchantString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(merchantString);
		
		ObjectMapper mapper = new ObjectMapper();
		Merchant m = mapper.readValue(merchantString, Merchant.class);
		System.out.println(m.getUname());
	}
	
	@Test
	public void testAdminGetAds() throws Exception{	
		String advertisementString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", "8a5e72cb5804223a0158042240820000");
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/a/getAdvertisement");
		advertisementString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(advertisementString);
		
		ObjectMapper mapper = new ObjectMapper();
		Advertisement a = mapper.readValue(advertisementString, Advertisement.class);
		System.out.println(a.getStatus());
	}
}
