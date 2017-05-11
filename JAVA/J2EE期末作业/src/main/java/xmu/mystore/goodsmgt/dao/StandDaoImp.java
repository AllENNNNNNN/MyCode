package xmu.mystore.goodsmgt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.model.Stand;
@Transactional
@Repository
public class StandDaoImp implements StandDao{

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
	
	@SuppressWarnings("unchecked")
	public List<Stand> getStandList() {
		// TODO Auto-generated method stub
		List<Stand> result=new ArrayList<Stand>();
		Session session=this.getSession();
		String hql="from Stand";
		Query query=session.createQuery(hql);
	    result=query.list();
	    session.close();
		return result;
	}

	public boolean addStand(Stand stand) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
		session.save(stand);
		t.commit();
		}
		catch(Exception e)
		{
			t.rollback();
			yes=false;
		}
		session.close();
		return yes;
	}

	public boolean deleteStandById(long id) {
		// TODO Auto-generated method stub
		boolean yes=true;
		String hql="delete Stand where id=?";
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
		Query q=session.createQuery(hql).setInteger(0, (int)id);
		q.executeUpdate();
		t.commit();
		}
		catch(Exception e)
		{
			t.rollback();
			yes=false;
		}
		session.close();
		return yes;
	}

	public Stand getStandById(long id) {
		// TODO Auto-generated method stub
		String hql="from Stand where id=?";
		Session session=this.getSession();
		Query q=session.createQuery(hql).setInteger(0, (int)id);
		Stand stand=(Stand) q.list().get(0);
		session.close();
		return stand;
	}

	public boolean updateStand(Stand stand) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
			session.update(stand);
			t.commit();
		}
		catch(Exception e)
		{
			t.rollback();
			yes=false;
			System.out.println(e.toString());
		}
		session.close();
		return yes;
	}

}
