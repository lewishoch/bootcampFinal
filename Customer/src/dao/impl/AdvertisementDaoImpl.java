package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import dao.AdvertisementDao;
import po.Advertisement;
import po.Merchant;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {

	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public List<Advertisement> findlastestAdv(int num) {
		
		String jpql = "select a from Advertisement a order by a.creDt desc";
		Query q = em.createQuery(jpql).setMaxResults(num);
		List<Advertisement> advertisements = q.getResultList();
		
		return advertisements;
	}
	
	

}
