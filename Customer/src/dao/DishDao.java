package dao;

import java.util.List;
import java.util.Set;

import po.Advertisement;
import po.Dish;

public interface DishDao {
	public Set<Dish> getAllDishes(int mid);
}
