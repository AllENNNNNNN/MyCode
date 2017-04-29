package com.wcf.SpringHibernate.service;

import java.util.List;

import com.wcf.SpringHibernate.domain.News;
import com.wcf.SpringHibernate.domain.User;

public interface NewsService {
	public String getNewsTitleById(int id);
	public void addNews(News news);
	public List<News> getNewsList();
	public List<News> getNewsListByUserId(int id);
	public List<News> getNewsListByTitle(String title);
	public void deleteNewsById(int id);
	public News getNewsById(int id);
}
