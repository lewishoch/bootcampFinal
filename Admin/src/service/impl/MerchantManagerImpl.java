package service.impl;

import java.util.List;

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
	
	@Override
	@Transactional
	public Merchant findMerchant(String mid) {
		Merchant m = md.loadMerchant(mid);
		return m;
	}

	@Override
	@Transactional
	public List<Merchant> findMerchantsByStatus(int status) {
		List<Merchant> ms = md.listAllMerchantsBySatus(status);
		return ms;
	}

	@Override
	@Transactional
	public void insertMerchant(Merchant m) {
		md.insertMerchant(m);
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		md.updateMerchant(m);
	}

}
