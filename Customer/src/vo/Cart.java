package vo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private String mid;
	private List<CartDish> cartDish = new ArrayList<CartDish>();
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public List<CartDish> getCartDish() {
		return cartDish;
	}
	public void setCartDish(List<CartDish> cartDish) {
		this.cartDish = cartDish;
	}
	
	

}
