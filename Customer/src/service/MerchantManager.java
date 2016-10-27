package service;

import java.util.List;

import po.Merchant;
import vo.AllShop;

public interface MerchantManager {

	
	public Merchant findMerchant(String id);
	public List<Merchant> findAllMerchant();
	public List<AllShop> findAllShop();
}
