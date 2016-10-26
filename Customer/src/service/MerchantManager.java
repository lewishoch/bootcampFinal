package service;

import java.util.List;

import po.Merchant;

public interface MerchantManager {

	
	public Merchant findMerchant(String id);
	public List<Merchant> findAllMerchant();
}
