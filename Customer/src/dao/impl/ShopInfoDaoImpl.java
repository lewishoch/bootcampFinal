package dao.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import po.Dish;
import po.Merchant;
import po.Order;
import dao.ShopInfoDao;

@Repository
public class ShopInfoDaoImpl implements ShopInfoDao {

	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public Set<Dish> findAllDishes(String mid) {
		Merchant m = em.find(Merchant.class, mid);
		if(m != null && m.getDishes() != null)
			return m.getDishes();
		else
			return null;
	}

	@Override
	public List<Order> findAllComments(String mid) {
		
		String jpql = "select o from Order o, Merchant m where m.mid = o.merchant.mid and m.id = :mid";
		List<Order> comments = em.createQuery(jpql).setParameter("mid", mid).getResultList();
		return comments;
	}

	@Override
	public List<Dish> findDishesByCategory(String category) {
		String jpql = "select d from Dish d, Merchant m where m.mid = d.merchant.mid and d.category=:category";
		Query q = em.createQuery(jpql);
		q.setParameter("category",category);
		List<Dish> dishes = q.getResultList();
		if(dishes!=null){
			return dishes;
		} else {
			return null;
		}
		
	}

	@Override
	public List<Merchant> loadShopInfo(String mid, String category) {
		
		String jpql = "select m from Merchant m where m.shop.sCat =:category and m.mid=:mid";
		Query q = em.createQuery(jpql);
		q.setParameter("category", category);
		q.setParameter("mid", mid);
		List<Merchant> shop = q.getResultList();
		if(shop!=null){
			return shop;
		} else {
			return null;
		}
	}

}
