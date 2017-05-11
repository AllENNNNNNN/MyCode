package xmu.mystore.goodsmgt.dao;

import java.util.ArrayList;
import java.util.List;

import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.model.Stand;

public interface GoodsDao {

	public List<Goods> getGoodsList();
	public boolean addGoods(Goods goods);
	public boolean deleteGoodsById(long id);
	public Goods getGoodsById(long id);
	public boolean updateGoods(Goods goods);
	public Goods getGoodsByGoodsCode(String serial_code);
	public List<Goods> getGoodsByGoodsName(String goods_name);
	public List<Goods> getGoodsBy(ArrayList<String> array);
	public Stand getGoodsPrice(Long goods_id);
}
