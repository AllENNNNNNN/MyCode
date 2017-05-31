package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Brand;



/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:33
*/
public interface BrandService {

	
	public List<Brand> getBrandList();
	public boolean addBrand(Brand brand);
	public boolean deleteBrandById(long id);
	public Brand getBrandById(long id);
	public boolean updateBrand(Brand brand);
	
	
}
