package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MerchantDao;
import po.Merchant;
import service.MerchantManager;
@Service
public class MerchantManagerImpl implements MerchantManager {
	@Autowired
	private MerchantDao md;
	
	@Override
	public Merchant findMerchant(String mid) {
		Merchant m = md.loadMerchant(mid);
		return m;
	}

}
