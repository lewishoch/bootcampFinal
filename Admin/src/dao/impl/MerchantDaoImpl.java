package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.MerchantDao;
import po.Merchant;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public List<Merchant> listAllMerchantsBySatus(int status) {
		String jpql="select m from Merchant m where m.status=:status";
		List<Merchant> ms = em
				.createQuery(jpql)
				.setParameter("status", status)
				.getResultList();
		return ms;
	}

	@Override
	@Transactional
	public void insertMerchant(Merchant m) {
		em.persist(m);
	}

	@Override
	public Merchant loadMerchant(String mid) {
		Merchant m = em.find(Merchant.class, mid);
		return m;
	}

	@Override
	@Transactional
	public void updateMerchant(Merchant m) {
		Merchant mer = em.find(Merchant.class, m.getMid());
		mer.setStatus(m.getStatus());
		mer.setLastModDt(new Date());
	}

}
