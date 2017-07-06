package com.wcf.SpringHibernate.service;

import com.wcf.SpringHibernate.domain.User;

public interface UserService {

	public String getUserNameById(int id);
	public void savaBook(User user);
}
