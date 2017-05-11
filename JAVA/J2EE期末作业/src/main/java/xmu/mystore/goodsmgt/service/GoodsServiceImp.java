package xmu.mystore.goodsmgt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.dao.GoodsDao;
import xmu.mystore.goodsmgt.model.Goods;
import xmu.mystore.goodsmgt.model.Stand;

@Transactional
@Service
public class GoodsServiceImp implements GoodsService{

	@Autowired
	private GoodsDao goodsDao;
	public List<Goods> getGoodsList() {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsList();
	}

	public boolean addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return this.goodsDao.addGoods(goods);
	}

	public boolean deleteGoodsById(long id) {
		// TODO Auto-generated method stub
		return this.goodsDao.deleteGoodsById(id);
	}

	public Goods getGoodsById(long id) {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsById(id);
	}

	public boolean updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return this.goodsDao.updateGoods(goods);
	}

	public Goods getGoodsByGoodsCode(String serial_code) {
		// TODO Auto-generated method stub
		return this.getGoodsByGoodsCode(serial_code);
	}

	public List<Goods> getGoodsByGoodsName(String goods_name) {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsByGoodsName(goods_name);
	}

	public List<Goods> getGoodsBy(ArrayList<String> array) {
		// TODO Auto-generated method stub
		return this.goodsDao.getGoodsBy(array);
	}

	public Stand getGoodsPrice(Long goods_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
