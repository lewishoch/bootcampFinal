package dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import dao.AdvertisementDao;
import dao.DishDao;
import po.Advertisement;
import po.Dish;
import po.Merchant;

@Repository
public class DishDaoImpl implements DishDao {

	@PersistenceContext(name="ds")
	private EntityManager em;
	
	
	@Override
	public Set<Dish> getAllDishes(int mid) {
		
		Merchant m = em.find(Merchant.class, mid);
		
		return m.getDishes();
		
	}
	
	

}
