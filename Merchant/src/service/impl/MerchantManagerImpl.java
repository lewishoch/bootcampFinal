package service.impl;

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
	
	@Transactional
	public Merchant loadMerchantById(String mid) {
		return md.loadMerchantById(mid);
	}

	@Transactional
	public Merchant loadMerchantByUname(String uname) {
		return md.loadMerchantByUname(uname);
	}
	
	@Transactional
	public Merchant addMerchant(Merchant m) {
		return md.addMerchant(m);
	}

	@Transactional
	public Merchant updateMerchant(Merchant m) {
		return md.updateMerchant(m);
	}

	@Transactional
	public Merchant deleteMerchant(int mid) {
		return md.deleteMerchant(mid);
	}
	
	@Transactional
	public void getMerchantByWebService(String mid) {
		String merchantString = "";
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", mid);
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/m/getMerchant");
		merchantString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(merchantString);	
	}

}
