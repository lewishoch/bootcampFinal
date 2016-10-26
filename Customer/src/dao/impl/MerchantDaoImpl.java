package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import po.Merchant;
import dao.MerchantDao;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	@PersistenceContext(name="ds")
	private EntityManager em;
	
	@Override
	public Merchant findMerchant(String id) {
		String jpql="select m from Merchant m where mid =:mid ";
		Query q = em.createQuery(jpql);
		q.setParameter("mid", id);
		List<Merchant> merchants = q.getResultList();
		if(merchants.get(0)!=null){
			return merchants.get(0);
		} else{
		return null;
		}
		
	}

	@Override
	public List<Merchant> findAllMerchant() {
		String jpql="select m from Merchant m";
		Query q = em.createQuery(jpql);
		List<Merchant> merchants = q.getResultList();
		return merchants;
	}

}
