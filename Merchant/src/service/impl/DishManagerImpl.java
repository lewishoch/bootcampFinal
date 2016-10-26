package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DishDao;
import po.Dish;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager {

	@Autowired
	private DishDao dd;
	
	@Transactional
	public List<Dish> findAllOwnDishes(String mid) {
		return dd.findAllOwnDishes(mid);
	}

	@Transactional
	public Dish loadDish(String did) {
		return dd.loadDish(did);
	}

	@Transactional
	public Dish loadDish(String did, String dname) {
		return dd.loadDish(did, dname);
	}

	@Transactional
	public void addDish(Dish d) {
		dd.addDish(d);
	}

	@Transactional
	public void deleteDish(int did) {
		dd.deleteDish(did);
	}

}
