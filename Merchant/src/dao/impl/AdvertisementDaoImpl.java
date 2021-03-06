package dao.impl;

import java.util.Date;
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
		String jpql = "select a from Advertisement a where a.merchant.mid=:mid order by a.creDt desc";
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

	@Override
	public void updateAdvertisement(Advertisement a) {
		System.out.println(a.getAid()+"..."+a.getStatus());
		Advertisement ad = em.find(Advertisement.class, a.getAid());
		System.out.println(ad.getAid()+"..."+ad.getStatus());
		ad.setStatus(a.getStatus());
		ad.setLastModDt(new Date());
		System.out.println(ad.getAid()+"..."+ad.getStatus());
	}
}
