package service;

import java.util.List;

import po.Dish;

public interface DishManager {
	public List<Dish> findAllOwnDishes(String mid);
	public Dish loadDish(String did);
	public Dish loadDish(String mid, String dname);
	public Dish addDish(Dish d);
	public Dish deleteDish(String did);
}
