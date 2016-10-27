package service.impl;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import dao.MerchantDao;
import po.Merchant;
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
		md.insertMerchant(m);
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		md.updateMerchant(m);
	}

	@Override
	@Transactional
	public void getMerchantByWebService(String mid) {
		String merchantString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", mid);
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://localhost:8081/Admin/m/getMerchant");
		merchantString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(merchantString);	
	}

}
