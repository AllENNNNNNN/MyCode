package com.wcf.SpringHibernate.dao;

import com.wcf.SpringHibernate.domain.User;

public interface UserDao {
	//public User findUserById(int id);
	public String getUseNameById(int id); 
	public void addUser(User user);
	public boolean hasUser(String username,String password);
	public User getUserByName(String name);

}
