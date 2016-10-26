package dao;

import java.util.List;

import po.Dish;
import po.Merchant;
import po.Order;

public interface ShopInfoDao {
	
	public List<Merchant> loadShopInfo(String mid, String category);
	public List<Dish> findAllDishes();
	public List<Order> findAllComments();
	//public ShoppingCart addToShoppingCart();
	public List<Dish> findDishesByCategory(String category);

}
