package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdvertisementDao;
import po.Advertisement;
import po.Merchant;
import service.AdvertisementManager;

@Service
public class AdvertisementManagerImpl implements AdvertisementManager{
	@Autowired
	private AdvertisementDao ad;

	@Override
	@Transactional
	public List<Advertisement> findlastestAdv(int num) {
		// TODO Auto-generated method stub
		return ad.findlastestAdv(num);
	}
	
	
}
