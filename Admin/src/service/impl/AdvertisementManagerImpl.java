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
	
	@Override
	public List<Advertisement> findAllAds() {
		return null;
	}

	@Override
	public Advertisement findAd(String aid) {
		return null;
	}

	@Override
	@Transactional
	public void insertAd(Advertisement a) {
		ad.insertAd(a);
	}

	@Override
	@Transactional
	public void updateAd(Advertisement a) {

	}

}
