package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import po.Advertisement;
import dao.AdvertisementDao;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	public List<Advertisement> findAllOwnAdvertisements(String mid) {
		String jpql = "select a from Advertisement a where a.merchant.mid=:mid";
		List<Advertisement> as = em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.getResultList();
		return as;
	}

	public Advertisement addAdvertisement(Advertisement a) {
		em.persist(a);
		return a;
	}

	public Advertisement loadAdvertisement(String aid) {
		String jpql = "select a from Advertisement a where a.aid=:aid";
		Advertisement a = (Advertisement)em
				.createQuery(jpql)
				.setParameter("aid", aid)
				.getSingleResult();
		return a;
	}
}
