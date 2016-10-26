package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdvertisementDao;
import po.Advertisement;
import service.AdvertisementManager;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager {

	@Autowired
	private AdvertisementDao ad;
	
	@Transactional
	public List<Advertisement> findAllOwnAdvertisements(String mid) {
		return ad.findAllOwnAdvertisements(mid);
	}

	@Transactional
	public void addAdvertisement(Advertisement a) {
		ad.addAdvertisement(a);
	}

}
