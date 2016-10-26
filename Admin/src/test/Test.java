package test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdminAccountDao;
import po.AdminAccount;

public class Test {
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	private AdminAccountDao aad = (AdminAccountDao)context.getBean(AdminAccountDao.class);
	
	
	@org.junit.Test
	public void testLoadAdmin(){
		AdminAccount aa = aad.loadAdmin("admin");
		System.out.println(aa.getUname());
	}
	
	@org.junit.Test
	public void testInsertAdmin(){
		AdminAccount aa = new AdminAccount();
		aa.setUname("admin");
		aa.setPsd("admin");
		aa.setCreDt(new Date());
		aa.setLastModDt(new Date());
		aad.insertAdmin(aa);
	}
}
