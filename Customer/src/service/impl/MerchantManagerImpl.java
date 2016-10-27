package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Merchant;
import po.ShopInfo;
import service.MerchantManager;
import vo.AllShop;
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
		
		
		List<Merchant> ms = md.findAllMerchant();
		for(Merchant m: ms)
		{
			ShopInfo s = m.getShop();
			
		}
		
		return ms;
	}

	@Override
	public List<AllShop> findAllShop() {
		
		List<AllShop> allShops = new ArrayList<AllShop>();
		
		List<Merchant> ms = md.findAllMerchant();
		for(Merchant m: ms)
		{
			AllShop allShop = new AllShop();
			
			ShopInfo s = m.getShop();
			allShop.setName(s.getsName());
			allShop.setTel(s.getsTel());
			allShop.setAddr(s.getsAddr());
			allShop.setPicPath(s.getsLogoPath());
			allShop.setRating(m.getRating());
			allShop.setMid(m.getMid());
			allShop.setCat(s.getCat());
			
			allShops.add(allShop);
		}
		
		return allShops;
	}

}
