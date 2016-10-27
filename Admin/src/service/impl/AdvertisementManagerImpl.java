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

import dao.AdvertisementDao;
import po.Advertisement;
import po.Merchant;
import service.AdvertisementManager;
@Service
public class AdvertisementManagerImpl implements AdvertisementManager {

	@Autowired
	private AdvertisementDao ad;
	
	@Override
	@Transactional
	public List<Advertisement> findAllAds() {
		List<Advertisement> as = ad.loadAllAds();
		return as;
	}

	@Override
	@Transactional
	public Advertisement findAd(String aid) {
		Advertisement a = ad.loadAd(aid);
		return a;
	}

	@Override
	@Transactional
	public void insertAd(Advertisement a) {
		ad.insertAd(a);
	}

	@Override
	@Transactional
	public void updateAd(Advertisement a) {
		ad.updateAd(a);
	}

	@Override
	@Transactional
	public Advertisement getAdvertisementByWebService(String aid) {
		String adString = "";
		Advertisement ad = null;
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("aid", aid);
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.242.75:8080/Merchant/advertisement/getAdvertisement");
		adString  = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		
		System.out.println(adString);	
		
		try {
			ad = new ObjectMapper().readValue(adString, Advertisement.class);
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
		
		return ad;
	}

}
