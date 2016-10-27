package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
