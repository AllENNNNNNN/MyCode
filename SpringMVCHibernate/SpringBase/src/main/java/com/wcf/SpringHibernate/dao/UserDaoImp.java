package com.wcf.SpringHibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wcf.SpringHibernate.domain.User;
@Transactional
@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession()
	{
		Session session;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}


	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=this.getSession();
		session.save(user);
		session.close();
	}


	public String getUseNameById(int id) {
		// TODO Auto-generated method stub
		String hql="SELECT username from User where id =?";
		Session session=this.getSession();
		Query query=session.createQuery(hql).setInteger(0, 1);
		String str=query.uniqueResult().toString();
		session.close();
		return str;


	}


	public boolean hasUser(String username, String password) {
		// TODO Auto-generated method stub
		String hql="SELECT username from User where username=? and password=?";
		Session session=this.getSession();
		Query query=session.createQuery(hql).setString(0, username).setString(1, password);
		boolean b=!query.list().isEmpty();
		session.close();
		return b;
	}


	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		String hql="From User where username=?";
		Session session=this.getSession();
		Query query=session.createQuery(hql).setString(0, name);
		User user=(User)query.list().get(0);
		session.close();
		return user;
	}

}
