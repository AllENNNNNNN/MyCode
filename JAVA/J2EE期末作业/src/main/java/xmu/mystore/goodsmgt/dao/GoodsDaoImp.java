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

import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.model.Stand;

@Transactional
@Repository
public class GoodsDaoImp implements GoodsDao{

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
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		List<Goods> result=new ArrayList<Goods>();
		Session session=this.getSession();
		String hql="from Goods";
		Query query=session.createQuery(hql);
		result=query.list();
		session.close();
		return result;
	}

	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
		session.save(goods);
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

	public boolean deleteGoodsById(long id) {
		// TODO Auto-generated method stub
		boolean yes=true;
		String hql="delete Goods where id=?";
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

	public Goods getGoodsById(long id) {
		// TODO Auto-generated method stub
		String hql="from Goods where id=?";
		Session session=this.getSession();
		Query q=session.createQuery(hql).setInteger(0, (int)id);
		Goods goods=(Goods) q.list().get(0);
		session.close();
		return goods;
	}

	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		boolean yes=true;
		Session session=this.getSession();
		Transaction t=session.beginTransaction();
		try
		{
			session.update(goods);
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

	public Goods getGoodsByGoodsCode(String serial_code) {
		// TODO Auto-generated method stub
		String hql="from Goods where serial_code=?";
		Session session=this.getSession();
		Query query=session.createQuery(hql).setString(0, serial_code);
		Goods good=null;
		if(query.list().size()==0)
		{
			System.out.println("²»´æÔÚ");
		}
		else
		{
			good=(Goods) query.list().get(0);
		}
		session.close();
		return good;
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		String Hql="from News n where n.title like '%"+goods_name+"%'";
		Session session=this.getSession();
		Query query=session.createQuery(Hql);
		List<Goods> goodsList=query.list();
		return goodsList;
	}

	public List<Goods> getGoodsBy(ArrayList<String> array) {
		// TODO Auto-generated method stub
		return null;
	}

	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		//String hql="select pri"
		
		return null;
		
	}

}
