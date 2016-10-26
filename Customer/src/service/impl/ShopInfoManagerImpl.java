package service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ShopInfoDao;
import po.Dish;
import po.Merchant;
import po.Order;
import service.ShopInfoManager;

@Service
public class ShopInfoManagerImpl implements ShopInfoManager {

	@Autowired
	private ShopInfoDao sd;
	
	@Override
	public Set<Dish> findAllDishes(String mid) {
		return sd.findAllDishes(mid);
	}

	@Override
	public List<Order> findAllComments(String mid) {
		return sd.findAllComments(mid);
	}

	@Override
	public List<Dish> findDishesByCategory(String category) {
		return sd.findDishesByCategory(category);
	}

	@Override
	public List<Merchant> loadShopInfo(String mid, String category) {
		return sd.loadShopInfo(mid, category);
	}

}
