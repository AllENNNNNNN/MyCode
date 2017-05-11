package xmu.mystore.goodsmgt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.dao.BrandDao;
import xmu.mystore.goodsmgt.dao.CategoryDao;
import xmu.mystore.goodsmgt.dao.GoodsDao;
import xmu.mystore.goodsmgt.model.Brand;
import xmu.mystore.goodsmgt.model.Category;
import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.model.Stand;
@Transactional
@Service
public class IGoodsMapperImp implements IGoodsMapper{

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private BrandDao brandDao;
	@Autowired
	private CategoryDao categoryDao;
	public Goods getGoodsByGoodsCode(String serial_code) {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsByGoodsCode(serial_code);
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsByGoodsName(goods_name);
	}

	public List<Goods> getGoodsBy(Map<String, String> array) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return this.brandDao.getBrandList();
	}

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return this.categoryDao.getCategoryList();
	}

	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
