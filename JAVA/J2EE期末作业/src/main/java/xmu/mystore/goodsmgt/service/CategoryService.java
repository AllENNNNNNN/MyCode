package xmu.mystore.goodsmgt.service;

import java.util.List;

import xmu.mystore.goodsmgt.model.Category;

public interface CategoryService {
	public List<Category> getCategoryList();
	public boolean addCategory(Category category);
	public boolean deleteCategoryById(long id);
	public Category getCategoryById(long id);
	public boolean updateCategory(Category category);

}
