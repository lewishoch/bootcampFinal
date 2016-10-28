package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import dao.OrderedDishDao;
import po.OrderedDish;

@Repository
public class OrderedDishDaoImpl implements OrderedDishDao{

	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public void createOrdeedDish(OrderedDish orderedDish) {
		em.persist(orderedDish);
		
	}

}
