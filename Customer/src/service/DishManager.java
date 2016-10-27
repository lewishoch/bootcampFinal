package service;

import java.util.List;
import java.util.Set;

import po.Advertisement;
import po.Dish;

public interface DishManager {

	public List<Dish> getAllDishes(String mid);
}
