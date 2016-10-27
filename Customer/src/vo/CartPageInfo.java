package vo;

import java.util.List;
import java.util.Set;

public class CartPageInfo {

	private ShopInfo shopInfo;
	private Cart cart;
	private Set<Dish> dish;
	
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Set<Dish> getDish() {
		return dish;
	}
	public void setDish(Set<Dish> dish) {
		this.dish = dish;
	}
	
	
	
}
