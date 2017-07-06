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
		
		this.getSession().save(user);
	}


	public String getUseNameById(int id) {
		// TODO Auto-generated method stub
		String hql="SELECT username from User where id =?";
		Query query=this.getSession().createQuery(hql).setInteger(0, 1);
		String str=query.uniqueResult().toString();
		return str;
		
	
	}

}
