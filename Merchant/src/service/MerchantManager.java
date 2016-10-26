package service;

import po.Merchant;

public interface MerchantManager {
	public Merchant loadMerchantById(String mid);
	public Merchant loadMerchantByUname(String uname);
	public void addMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void deleteMerchant(int mid);
}
