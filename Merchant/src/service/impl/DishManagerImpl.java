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
	public Dish loadDish(String mid, String dname) {
		return dd.loadDish(mid, dname);
	}

	@Transactional
	public Dish addDish(Dish d) {
		return dd.addDish(d);
	}

	@Transactional
	public Dish deleteDish(String did) {
		return dd.deleteDish(did);
	}

}
