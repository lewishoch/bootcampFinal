package dao;

import java.util.List;

import po.Merchant;

public interface MerchantDao {
	public List<Merchant> listAllMerchantsBySatus(int status);
	public void insertMerchant(Merchant m);
	public void updateMerchant(Merchant m);
	public Merchant loadMerchant(String mid);
}
