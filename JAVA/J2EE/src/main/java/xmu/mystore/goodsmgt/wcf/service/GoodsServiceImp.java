package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wcf.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:44:59
*/
@Transactional
@Service
public class GoodsServiceImp implements GoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsList();
	}

	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return this.goodsMapper.addGoods(goods);
	}

	public boolean deleteGoodsById(long id) {
		// TODO Auto-generated method stub
		return this.goodsMapper.deleteGoodsById(id);
	}

	public Goods getGoodsById(long id) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsById(id);
	}

	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return this.goodsMapper.updateGoods(goods);
	}

	public Goods getGoodsByGoodsCode(String serial_code) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByGoodsCode(serial_code);
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return this.goodsMapper.getGoodsByGoodsName(goods_name);
	}



	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
