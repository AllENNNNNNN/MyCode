package com.wcf.SpringHibernate.service;

import com.wcf.SpringHibernate.domain.User;

public interface UserService {

	public String getUserNameById(int id);
	public void savaUser(User user);
	public boolean hasUser(String username,String password);
	public User getUserByName(String name);
}
