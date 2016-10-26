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

}
