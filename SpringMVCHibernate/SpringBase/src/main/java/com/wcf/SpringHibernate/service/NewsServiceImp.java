package com.wcf.SpringHibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wcf.SpringHibernate.dao.NewsDao;
import com.wcf.SpringHibernate.domain.News;
import com.wcf.SpringHibernate.domain.User;
@Transactional
@Service
public class NewsServiceImp implements NewsService{
	
	@Autowired
	private NewsDao newsDao;

	public String getNewsTitleById(int id) {
		// TODO Auto-generated method stub
		return this.newsDao.getNewsTitleById(id);
	}

	public void addNews(News news) {
		this.newsDao.addNews(news);
		// TODO Auto-generated method stub
		
	}

	public List<News> getNewsList() {
		// TODO Auto-generated method stub
		return this.newsDao.getNewsList();
	}

	public List<News> getNewsListByUserId(int id) {
		// TODO Auto-generated method stub
		return this.newsDao.getNewsListByUserId(id);
	}

	public List<News> getNewsListByTitle(String title) {
		// TODO Auto-generated method stub
		return this.newsDao.getNewsListByTitle(title);
	}

	public void deleteNewsById(int id) {
		// TODO Auto-generated method stub
		this.newsDao.deleteNewsById(id);
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return this.newsDao.getNewsById(id);
	}


	

}
