package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AdminAccountDao;
import po.AdminAccount;
import service.AdminManager;

@Service
public class AdminManagerImpl implements AdminManager {
	@Autowired
	private AdminAccountDao aad;
	
	@Override
	public boolean isValidate(AdminAccount aa) {
		AdminAccount aa1 = aad.loadAdmin(aa.getUname());
		if(aa1.getUname().equals(aa.getUname()) && aa1.getPsd().equals(aa.getPsd()))
			return true;
		else
			return false;
	}

}
