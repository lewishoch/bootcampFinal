package dao;

import java.util.List;
import java.util.Set;

import po.Advertisement;
import po.Dish;

public interface DishDao {
	public List<Dish> getAllDishes(String mid);
	public Dish getDish(String did) ;
}
