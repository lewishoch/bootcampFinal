package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DishDao;
import dao.OrderedDishDao;
import po.OrderedDish;
import service.OrderedDishManager;

@Service
public class OrderedDishManagerImpl implements OrderedDishManager {

	@Autowired
	private OrderedDishDao odd;
	
	@Override
	@Transactional
	public void createOrderedDish(OrderedDish orderedDish) {
		odd.createOrdeedDish(orderedDish);
		
	}

}
