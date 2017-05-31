package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wcf.mapper.BrandMapper;
import xmu.mystore.goodsmgt.wcf.model.Brand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:37
*/
@Transactional
@Service
public class BrandServiceImp implements BrandService{

	@Autowired
	private BrandMapper brandMapper;
	
	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		//System.out.println(this.brandMapper.getBrandList());
		return this.brandMapper.getBrandList();
	}
	public boolean addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return this.brandMapper.addBrand(brand);
	}
	public boolean deleteBrandById(long id) {
		// TODO Auto-generated method stub
		return this.brandMapper.deleteBrandById(id);
	}
	public Brand getBrandById(long id) {
		// TODO Auto-generated method stub
		return this.brandMapper.getBrandById(id);
	}
	public boolean updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return this.brandMapper.updateBrand(brand);
	}
	

}
