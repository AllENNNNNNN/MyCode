package xmu.mystore.goodsmgt.wcf.service.outter;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wcf.mapper.BrandMapper;
import xmu.mystore.goodsmgt.wcf.mapper.CategoryMapper;
import xmu.mystore.goodsmgt.wcf.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.wcf.mapper.StandMapper;
import xmu.mystore.goodsmgt.wcf.model.Brand;
import xmu.mystore.goodsmgt.wcf.model.Category;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:36
*/
@Transactional
@Service
public class IGoodsMapperImp implements IGoodsMapper{


	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private BrandMapper brandMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private StandMapper standMapper;
	public Goods getGoodsByGoodsCode(String serial_code) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByGoodsCode(serial_code);
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByGoodsName(goods_name);
	}

	public List<Brand> getBrandList() {
		// TODO Auto-generated method stub
		return this.brandMapper.getBrandList();
	}

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return this.categoryMapper.getCategoryList();
	}

	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		return this.standMapper.getGoodsPrice(goods_id);
	}

	public List<Goods> getGoodsBy(SelectParameters selectParameters) {
		// TODO Auto-generated method stub
	
		
		return this.goodsMapper.getGoodsBy(selectParameters);
	}

	public Boolean deleteGoodsNumById(String goodsId, int num) {
		// TODO Auto-generated method stub
		this.goodsMapper.deleteGoodsNumById(goodsId, num);
		return true;
	}

}
