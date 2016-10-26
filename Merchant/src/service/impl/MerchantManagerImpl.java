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
	public void addMerchant(Merchant m) {
		md.addMerchant(m);
	}

	@Transactional
	public void updateMerchant(Merchant m) {
		md.updateMerchant(m);
	}

	@Transactional
	public void deleteMerchant(int mid) {
		md.deleteMerchant(mid);
	}

}
