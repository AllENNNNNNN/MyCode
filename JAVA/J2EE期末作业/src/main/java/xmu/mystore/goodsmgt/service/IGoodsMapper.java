package xmu.mystore.goodsmgt.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.model.Brand;
import xmu.mystore.goodsmgt.model.Category;
import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.model.Stand;

public interface IGoodsMapper {
	
	public Goods getGoodsByGoodsCode(String serial_code);
	public List<Goods> getGoodsByGoodsName(String goods_name);
	public List<Goods> getGoodsBy(Map<String,String> array);
	public List<Brand> getBrandList();  
	public List<Category> getCategoryList(); 
	public Stand getGoodsPrice(Long goods_id) ;
}
