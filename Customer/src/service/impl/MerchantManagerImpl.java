package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.MerchantDao;
import po.Merchant;
import service.MerchantManager;

public class MerchantManagerImpl implements MerchantManager {

	@Autowired
	private MerchantDao md;
	@Override
	public Merchant findMerchant(String id) {
		return md.findMerchant(id);
	}

	@Override
	public List<Merchant> findAllMerchant() {
		return md.findAllMerchant();
	}

}
