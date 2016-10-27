package vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllDishOfMerchant {
	Set<Dish> dish = new HashSet<Dish>();
	List<Comment> comment = new ArrayList<Comment>();
	Merchant merchant;
	Cart cart;
	
	
	public Set<Dish> getDish() {
		return dish;
	}
	public void setDish(Set<Dish> dish) {
		this.dish = dish;
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
}
