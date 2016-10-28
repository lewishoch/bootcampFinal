package service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AdvertisementDao;
import dao.DishDao;
import po.Advertisement;
import po.Dish;
import po.Merchant;
import service.AdvertisementManager;
import service.DishManager;

@Service
public class DishManagerImpl implements DishManager{
	@Autowired
	private DishDao dd;

	@Override
	@Transactional
	public List<Dish> getAllDishes(String mid) {
		// TODO Auto-generated method stub
		return dd.getAllDishes(mid);
	}
	
	@Override
	@Transactional
	public Dish getDish(String did) {
		// TODO Auto-generated method stub
		return dd.getDish(did);
	}
	
	
}
