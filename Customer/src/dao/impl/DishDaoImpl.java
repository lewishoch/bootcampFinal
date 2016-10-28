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
	public List<Dish> getAllDishes(String mid) {
		
		String jpql = "select d from Dish d, Merchant m where d.merchant.mid = m.mid and d.merchant.mid=:mid";
		Query q = em.createQuery(jpql);
		q.setParameter("mid", mid);
		List<Dish> d = q.getResultList();
		if(d.size()>0)
		{
			return d;
		} else {
			return null;
		}
	
	
	}


	@Override
	public Dish getDish(String did) {
		return em.find(Dish.class, did);
	}
}
