package service;

import java.util.List;

import po.Merchant;

public interface MerchantManager {
	public Merchant findMerchant(String mid);
	public List<Merchant> findMerchantsByStatus(int status);
	public void insertMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void getMerchantByWebService(String mid);
}
