package service;

import java.util.List;
import java.util.Set;

import po.Dish;
import po.Merchant;
import po.Order;

public interface ShopInfoManager {

	public Set<Dish> findAllDishes(String mid);
	public List<Order> findAllComments(String mid);
	public List<Dish> findDishesByCategory(String category);
	public List<Merchant> loadShopInfo(String mid, String category);
}
