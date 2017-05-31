package xmu.mystore.goodsmgt.wcf.service.outter;

import java.util.List;
import xmu.mystore.goodsmgt.wcf.model.Brand;
import xmu.mystore.goodsmgt.wcf.model.Category;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:28
*/
public interface IGoodsMapper {
	
	public Goods getGoodsByGoodsCode(String serial_code);
	public List<Goods> getGoodsByGoodsName(String goods_name);
	public List<Goods> getGoodsBy(SelectParameters selectParameters);
	public List<Brand> getBrandList();  
	public List<Category> getCategoryList(); 
	public Stand getGoodsPrice(Long goods_id) ;
	public Boolean deleteGoodsNumById(String goodsId, int num);
}
