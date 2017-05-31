package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wcf.mapper.CategoryMapper;
import xmu.mystore.goodsmgt.wcf.model.Category;

/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:49
*/
@Transactional
@Service
public class CategoryServiceImp implements CategoryService {

	

	@Autowired
	private CategoryMapper categoryMapper;
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return this.categoryMapper.getCategoryList();
	}

	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryMapper.addCategory(category);
	}

	public boolean deleteCategoryById(long id) {
		// TODO Auto-generated method stub
		return this.categoryMapper.deleteCategoryById(id);
	}

	public Category getCategoryById(long id) {
		// TODO Auto-generated method stub
		return this.categoryMapper.getCategoryById(id);
	}

	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.categoryMapper.updateCategory(category);
	}


}
