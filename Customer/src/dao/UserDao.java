package dao;


import po.User;

public interface UserDao {

	public User addUser(User u);
	public User loadUser(String id);
	public User update(User u);
}
