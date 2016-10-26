package dao;

import po.AdminAccount;

public interface AdminAccountDao {
	public AdminAccount loadAdmin(String uname);
	public void insertAdmin(AdminAccount aa);
}
