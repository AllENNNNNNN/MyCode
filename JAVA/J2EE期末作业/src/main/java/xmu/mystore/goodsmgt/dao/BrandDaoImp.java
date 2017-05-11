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
import xmu.mystore.goodsmgt.model.Brand;

@Transactional
@Repository
public class BrandDaoImp implements BrandDao{

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
	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		List<Brand> result=new ArrayList<Brand>();
		Session session=this.getSession();
		String hql="from Brand";
		Query query=session.createQuery(hql);
	    result=query.list();
	    session.close();
		return result;
	}

	public boolean addBrand(Brand brand) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
		session.save(brand);
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

	public boolean deleteBrandById(long id) {
		// TODO Auto-generated method stub
		boolean yes=true;
		String hql="delete Brand where id=?";
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

	public Brand getBrandById(long id) {
		// TODO Auto-generated method stub
		String hql="from Brand where id=?";
		Session session=this.getSession();
		Query q=session.createQuery(hql).setInteger(0, (int)id);
		Brand brand=(Brand) q.list().get(0);
		session.close();
		return brand;
	}

	public boolean updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
			session.update(brand);
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
