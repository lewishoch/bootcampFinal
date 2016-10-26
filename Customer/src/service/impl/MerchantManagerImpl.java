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
	public Merchant findMerchant(String id) {
		return md.findMerchant(id);
	}

	@Override
	@Transactional
	public List<Merchant> findAllMerchant() {
		return md.findAllMerchant();
	}

}
