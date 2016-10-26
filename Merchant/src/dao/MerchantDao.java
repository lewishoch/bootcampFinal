package dao;

import po.Merchant;

public interface MerchantDao {
	public Merchant loadMerchantById(String mid);
	public Merchant loadMerchantByUname(String uname);
	public void addMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public void deleteMerchant(int mid);
}
