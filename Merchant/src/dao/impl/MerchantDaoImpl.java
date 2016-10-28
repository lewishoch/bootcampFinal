package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import po.Merchant;
import po.ShopInfo;
import dao.MerchantDao;

@Repository
public class MerchantDaoImpl implements MerchantDao {

	@PersistenceContext(name="em")
	private EntityManager em;
	
	public Merchant loadMerchantById(String mid) {
		String jpql = "select m from Merchant m where m.mid=:mid";
		Merchant m = (Merchant) em
				.createQuery(jpql)
				.setParameter("mid", mid)
				.getSingleResult();
		return m;
	}

	public Merchant loadMerchantByUname(String uname) {
		String jpql = "select m from Merchant m where m.uname=:uname";
		Merchant m;
		try {
			m = (Merchant) em
					.createQuery(jpql)
					.setParameter("uname", uname)
					.getSingleResult();
			return m;
		} catch (Exception e) {
			return null;
		}
	}

	public Merchant addMerchant(Merchant m) {
		em.persist(m);
		return m;
	}

	public Merchant updateMerchant(Merchant m) {
		Merchant newM = em.find(Merchant.class, m.getMid());
		
		ShopInfo si = new ShopInfo();
		si.setsName(m.getShop().getsName());
		si.setsAddr(m.getShop().getsAddr());
		si.setsCat(m.getShop().getsCat());
		si.setsTel(m.getShop().getsTel());
		si.setsLogoPath(m.getShop().getsLogoPath());
		si.setsStat(m.getShop().getsStat());
		
		newM.setShop(si);
		
		newM.setLastModDt(m.getLastModDt());
		
		em.persist(newM);
		
		return newM;
	}

	public Merchant deleteMerchant(int mid) {
		Merchant m = em.find(Merchant.class, mid);
		
		em.remove(m);
		
		return m;
	}

}
