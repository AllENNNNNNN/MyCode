package xmu.mystore.goodsmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.dao.CategoryDao;
import xmu.mystore.goodsmgt.model.Category;
@Transactional
@Service
public class CategoryServiceImp implements CategoryService {

	
	@Autowired
	private CategoryDao categoryDao; 
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return this.categoryDao.getCategoryList();
	}

	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryDao.addCategory(category);
	}

	public boolean deleteCategoryById(long id) {
		// TODO Auto-generated method stub
		return this.categoryDao.deleteCategoryById(id);
	}

	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return this.categoryDao.getCategoryById(id);
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryDao.updateCategory(category);
	}


}
