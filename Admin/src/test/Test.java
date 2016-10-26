package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.AdminAccountDao;
import dao.impl.AdminAccountDaoImpl;

public class Test {

	private AdminAccountDao aad = new AdminAccountDaoImpl();
	
	@org.junit.Test
	public void testConfig(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@org.junit.Test
	public void testLoadAdmin(){
		aad.loadAdmin("test");
	}
}
