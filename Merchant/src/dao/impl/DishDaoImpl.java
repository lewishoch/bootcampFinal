package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import po.Dish;
import dao.DishDao;

@Repository
public class DishDaoImpl implements DishDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	public List<Dish> findAllOwnDishes(String mid) {
		String jpql = "select d from Dish d where d.mid=:mid";
		List<Dish> ds = em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.getResultList();
		return ds;
	}

	public Dish loadDish(String did) {
		return em.find(Dish.class, did);
	}

	public Dish loadDish(String mid, String dname) {
		String jpql = "select d from Dish d where d.merchant.mid=:mid and d.dishName=:dname";
		try {
			Dish d = (Dish) em
					.createQuery(jpql)
					.setParameter("mid", mid)
					.setParameter("dname", dname)
					.getSingleResult();
			return d;
		} catch (Exception e) {
			return null;
		}
	}

	public void addDish(Dish d) {
		em.merge(d);
	}

	public void deleteDish(String did) {
		Dish d = em.find(Dish.class, did);
		
		em.remove(d);
	}

}
