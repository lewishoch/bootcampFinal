package dao;

import java.util.List;
import java.util.Set;

import po.Dish;
import po.Merchant;
import po.Order;

public interface ShopInfoDao {
	
	public List<Merchant> loadShopInfo(String mid, String category);
	public Set<Dish> findAllDishes(String mid);
	public List<Order> findAllComments(String mid);
	//public ShoppingCart addToShoppingCart();
	public List<Dish> findDishesByCategory(String category);

}
