package dao;

import po.Merchant;

public interface MerchantDao {
	public Merchant loadMerchantById(String mid);
	public Merchant loadMerchantByUname(String uname);
	public Merchant addMerchant(Merchant m);
	public Merchant updateMerchant(Merchant m);
	public Merchant deleteMerchant(int mid);
}
