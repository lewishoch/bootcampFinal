package service;

import java.util.List;

import po.Dish;
import po.Merchant;
import po.Order;

public interface ShopInfoManager {

	public List<Dish> findAllDishes();
	public List<Order> findAllComments();
	public List<Dish> findDishesByCategory(String category);
	public List<Merchant> loadShopInfo(String mid, String category);
}
