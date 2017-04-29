package com.wcf.SpringHibernate.dao;

import java.util.List;

import com.wcf.SpringHibernate.domain.News;

public interface NewsDao {
	
	public String getNewsTitleById(int id);
	public void addNews(News news);
	public List<News> getNewsList();
	public List<News> getNewsListByUserId(int id);
	public List<News> getNewsListByTitle(String title);
	public void deleteNewsById(int id);
	public News getNewsById(int id);

}
