package com.wcf.SpringHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wcf.SpringHibernate.dao.UserDao;
import com.wcf.SpringHibernate.domain.User;

@Transactional
@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;

	public String getUserNameById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUseNameById(id);
	}

	public void savaBook(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
		
	}

}
