package service.impl;

import java.util.List;

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
	public List<Dish> findAllDishes() {
		return sd.findAllDishes();
	}

	@Override
	public List<Order> findAllComments() {
		return sd.findAllComments();
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
