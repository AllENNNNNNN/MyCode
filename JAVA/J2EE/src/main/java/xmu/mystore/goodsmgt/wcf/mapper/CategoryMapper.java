package xmu.mystore.goodsmgt.wcf.mapper;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Category;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:00
*/
public interface CategoryMapper {
	public List<Category> getCategoryList();
	public boolean addCategory(Category category);
	public boolean deleteCategoryById(long id);
	public Category getCategoryById(long id);
	public boolean updateCategory(Category category);
}
