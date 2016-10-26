package dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.AdminAccountDao;
import po.AdminAccount;

@Repository
public class AdminAccountDaoImpl implements AdminAccountDao {
	@PersistenceContext(name="em")
	private EntityManager em;
	
	@Override
	public AdminAccount loadAdmin(String uname) {
		String jpql="select aa from AdminAccount aa where aa.uname=:a_uname";
		AdminAccount aa = (AdminAccount) em
				.createQuery(jpql)
				.setParameter("a_uname", uname)
				.getSingleResult();
		return aa;
	}

	@Override
	@Transactional
	public void insertAdmin(AdminAccount aa) {
		em.persist(aa);
	}

}
