package dao;

import java.util.List;

import po.Dish;

public interface DishDao {
	public List<Dish> findAllOwnDishes(String mid);
	public Dish loadDish(String did);
	public Dish loadDish(String mid, String dname);
	public void addDish(Dish d);
	public void deleteDish(String did);
}
