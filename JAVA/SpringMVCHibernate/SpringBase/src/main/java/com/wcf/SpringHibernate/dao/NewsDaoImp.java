package com.wcf.SpringHibernate.dao;

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

import com.wcf.SpringHibernate.domain.News;

@Transactional
@Repository
public class NewsDaoImp implements NewsDao{

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
	public String getNewsTitleById(int id) {
		// TODO Auto-generated method stub
		String Hql="SELECT title from News where id =?";
		Session session=this.getSession();
		Query query=session.createQuery(Hql).setInteger(0, 1);
		String str=query.uniqueResult().toString();
		session.close();
		return str;
	}

	public void addNews(News news) {
		Session session=this.getSession();
		session.save(news);
		System.out.println("已经添加!");
		//session.getTransaction().commit();
		session.close();
		// TODO Auto-generated method stub

	}
	@SuppressWarnings("unchecked")
	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		List<News> newsList=new ArrayList<News>();
		String Hql="from News";
		Session session=this.getSession();
		newsList=session.createQuery(Hql).list();
		session.close();
		//session.getTransaction().commit();
		return newsList;
	}
	@SuppressWarnings("unchecked")
	public List<News> getNewsListByUserId(int id) {
		// TODO Auto-generated method stub
		List<News> newsList=new ArrayList<News>();
		String Hql="SELECT news from News news "
				+ "JOIN FETCH news.user u where u.id=?";
		Session session=this.getSession();
		newsList=session.createQuery(Hql).setInteger(0, id).list();
		session.close();
		//session.getTransaction().commit();
		return newsList;
	}
	@SuppressWarnings("unchecked")
	public List<News> getNewsListByTitle(String title) {
		// TODO Auto-generated method stub
		List<News> newsList=new ArrayList<News>();
		String Hql="from News n where n.title like '%"+title+"%'";
		Session session=this.getSession();
		newsList=session.createQuery(Hql).list();
		session.close();
		//session.getTransaction().commit();
		return newsList;
	}
	public void deleteNewsById(int id) {
		// TODO Auto-generated method stub
		System.out.println("准备删除");
		String hql="delete News where id=?";
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		Query q=session.createQuery(hql).setInteger(0, id);
		q.executeUpdate();
		t.commit();
		System.out.println("已经删除!");
		session.close();

	}
	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		System.out.println("准备get");
		String hql="from News where id =?";
		Session session=this.getSession();
		Query q=session.createQuery(hql).setInteger(0, id);
		//session.getTransaction().commit();
		
		System.out.println("已经get");
		System.out.println(q);
		System.out.println(q.list());
		@SuppressWarnings("unchecked")
		News news=(News) q.list().get(0);
		session.close();
		return news;
	}

}
