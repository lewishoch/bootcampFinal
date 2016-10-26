package service.impl;

import java.util.List;

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

	@Override
	public List<Merchant> findMerchantsByStatus(int status) {
		List<Merchant> ms = md.listAllMerchantsBySatus(status);
		return ms;
	}

	@Override
	public void insertMerchant(Merchant m) {
		md.insertMerchant(m);
	}

	@Override
	public void updateMerchant(Merchant m) {
		md.updateMerchant(m);
	}

}
