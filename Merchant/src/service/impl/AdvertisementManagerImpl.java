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
import service.AdvertisementManager;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager {

	@Autowired
	private AdvertisementDao ad;
	
	@Override
	@Transactional
	public List<Advertisement> findAllOwnAdvertisements(String mid) {
		return ad.findAllOwnAdvertisements(mid);
	}

	@Override
	@Transactional
	public Advertisement addAdvertisement(Advertisement a) {
		return ad.addAdvertisement(a);
	}
	
	@Override
	@Transactional
	public Advertisement loadAdvertisement(String aid) {
		return ad.loadAdvertisement(aid);
	}
	
	@Override
	@Transactional
	public Advertisement getAdvertisementByWebService(String aid) {
		String advertisementString = "";
		Advertisement ad = null;
		Client client = Client.create();
		MultivaluedMap<String, String> params=new MultivaluedMapImpl();
		params.add("id", aid);
		client.setReadTimeout(1000);
		WebResource wr = client
				.resource("http://10.222.29.181:8081/Admin/a/getAdvertisement");
		advertisementString = wr
				.queryParams(params)
				.accept(MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
		System.out.println(advertisementString);	
		
		try {
			ad =  new ObjectMapper().readValue(advertisementString, Advertisement.class);
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

	@Override
	@Transactional
	public void updateAdvertisement(Advertisement a) {
		ad.updateAdvertisement(a);
	}

}
