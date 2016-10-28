package dao.impl;

import java.util.Date;
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
		Advertisement a = em.find(Advertisement.class, aid);
		return a;
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
		Advertisement a1 = em.find(Advertisement.class, a.getAid());
		a1.setStatus(a.getStatus());
		a1.setLastModDt(new Date());
	}

	@Override
	public void insertAd(Advertisement a) {
		em.persist(a);
	}

	@Override
	public List<Advertisement> loadAdsByStatus(String status) {
		String jpql="select a from Advertisement a where a.status=:status";
		List<Advertisement> as = em
				.createQuery(jpql)
				.setParameter("status", status)
				.getResultList();
		return as;
	}

}
