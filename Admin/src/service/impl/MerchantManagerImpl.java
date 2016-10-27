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

import dao.MerchantDao;
import po.Merchant;
import queue.protocal.MerchantMessage;
import service.MerchantManager;
@Service
public class MerchantManagerImpl implements MerchantManager {
	@Autowired
	private MerchantDao md;
	
	@Override
	@Transactional
	public Merchant findMerchant(String mid) {
		Merchant m = md.loadMerchant(mid);
		return m;
	}

	@Override
	@Transactional
	public List<Merchant> findMerchantsByStatus(int status) {
		List<Merchant> ms = md.listAllMerchantsBySatus(status);
		return ms;
	}

	@Override
	@Transactional
	public void insertMerchant(Merchant m) {
//		System.out.println("test");
		md.insertMerchant(m);
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		md.updateMerchant(m);
	}

	@Override
	@Transactional
	public Merchant getMerchantByWebService(String mid) {
		String merchantString = "";
		Merchant merchant = null;
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("mid", mid);
		client.setReadTimeout(1000);
		WebResource wr = client
//				.resource("http://localhost:8081/Admin/m/getMerchant");
//				.resource("http://10.222.242.9:8080/Merchant/getMerchant");
				.resource("http://10.222.242.75:8080/Merchant/merchant/getMerchant");
		
		merchantString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		
		System.out.println(merchantString);
		
		try {
			merchant = new ObjectMapper().readValue(merchantString, Merchant.class);
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
		return merchant;
	}

}
