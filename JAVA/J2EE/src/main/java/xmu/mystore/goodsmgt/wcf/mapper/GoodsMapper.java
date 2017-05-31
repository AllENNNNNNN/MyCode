package xmu.mystore.goodsmgt.wcf.mapper;

import java.util.List;

import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.service.outter.SelectParameters;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:03
*/
public interface GoodsMapper {
	public List<Goods> getGoodsList();
	public boolean addGoods(Goods goods);
	public boolean deleteGoodsById(long id);
	public Goods getGoodsById(long id);
	public boolean updateGoods(Goods goods);
	public Goods getGoodsByGoodsCode(String serial_code);
	public List<Goods> getGoodsByGoodsName(String goods_name);
	public List<Goods> getGoodsBy(SelectParameters selectParameters);
	public Boolean deleteGoodsNumById(String goodsId, Integer num);
}
