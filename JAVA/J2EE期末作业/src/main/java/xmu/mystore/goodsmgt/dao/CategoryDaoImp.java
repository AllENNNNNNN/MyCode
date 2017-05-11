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

import xmu.mystore.goodsmgt.model.Category;
@Transactional
@Repository
public class CategoryDaoImp implements CategoryDao {


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
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		List<Category> result=new ArrayList<Category>();
		Session session=this.getSession();
		String hql="from Category";
		Query query=session.createQuery(hql);
	    result=query.list();
	    session.close();
		return result;
	}


	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
		session.save(category);
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


	public boolean deleteCategoryById(long id) {
		// TODO Auto-generated method stub
		boolean yes=true;
		String hql="delete Category where id=?";
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


	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		String hql="from Category where id=?";
		Session session=this.getSession();
		Query q=session.createQuery(hql).setInteger(0, (int)id);
		Category category=(Category) q.list().get(0);
		session.close();
		return category;
	}


	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
			session.update(category);
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
