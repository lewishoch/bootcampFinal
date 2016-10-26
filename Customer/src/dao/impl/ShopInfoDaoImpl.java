package dao.impl;

import java.util.List;

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
	public List<Dish> findAllDishes() {
		String jpql = "select d from dish d, merchant m where m.mid = d.mid";
		Query q = em.createQuery(jpql);
		List<Dish> dishes = q.getResultList();
		return dishes;
	}

	@Override
	public List<Order> findAllComments() {
		String jpql = "select o.comments from orders o, merchant m where m.mid = o.mid";
		Query q = em.createQuery(jpql);
		List<Order> comments = q.getResultList();
		return comments;
	}

	@Override
	public List<Dish> findDishesByCategory(String category) {
		String jpql = "select d from dish d, merchant m where m.mid = d.mid and m.cate=:category";
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
		String jpql = "select m.sname, m.slogopath, m.scate, m.saddr, m.stel from merchant m where m.cate = :category and m.mid=:mid";
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
