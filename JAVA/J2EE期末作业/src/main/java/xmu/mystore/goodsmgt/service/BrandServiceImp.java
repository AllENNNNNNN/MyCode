package xmu.mystore.goodsmgt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.dao.BrandDao;
import xmu.mystore.goodsmgt.model.Brand;

@Transactional
@Service
public class BrandServiceImp implements BrandService{

	@Autowired
	private BrandDao brandDao;
	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return this.brandDao.getBrandList();
	}
	public boolean addBrand(Brand brand) {
		// TODO Auto-generated method stub
		return this.brandDao.addBrand(brand);
	}
	public boolean deleteBrandById(long id) {
		// TODO Auto-generated method stub
		return this.brandDao.deleteBrandById(id);
	}
	public Brand getBrandById(long id) {
		// TODO Auto-generated method stub
		return this.brandDao.getBrandById(id);
	}
	public boolean updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return this.brandDao.updateBrand(brand);
	}
	

}
