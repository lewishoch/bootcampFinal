package dao;

import java.util.List;

import po.Merchant;

public interface MerchantDao {

	public Merchant findMerchant(String id);
	public List<Merchant> findAllMerchant();
}
