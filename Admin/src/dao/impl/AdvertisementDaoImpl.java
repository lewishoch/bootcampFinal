package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.AdvertisementDao;
import po.Advertisement;
import po.Merchant;

@Repository
public class AdvertisementDaoImpl implements AdvertisementDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public Advertisement loadAd(String aid) {
		return null;
	}

	@Override
	public List<Advertisement> loadAllAds() {
		String jpql="select a from Advertisement a";
		List<Advertisement> as = em
				.createQuery(jpql)
//				.setParameter("status", status)
				.getResultList();
		return as;
	}

	@Override
	public void updateAd(Advertisement a) {

	}

	@Override
	public void insertAd(Advertisement a) {
		em.persist(a);
	}

}
