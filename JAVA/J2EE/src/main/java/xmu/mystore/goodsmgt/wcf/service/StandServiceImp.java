package xmu.mystore.goodsmgt.wcf.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xmu.mystore.goodsmgt.wcf.mapper.GoodsMapper;
import xmu.mystore.goodsmgt.wcf.mapper.StandMapper;
import xmu.mystore.goodsmgt.wcf.model.Goods;
import xmu.mystore.goodsmgt.wcf.model.Stand;


/**
*@author created by 王崇菲
*@date 2017年5月31日--下午1:45:19
*/
@Transactional
@Service
public class StandServiceImp implements StandService{

	@Autowired
	private StandMapper standMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	public List<Stand> getStandList() {
		// TODO Auto-generated method stub
		return this.standMapper.getStandList();
	}

	public boolean addStand(Stand stand) {
		// TODO Auto-generated method stub
		Goods goods=this.goodsMapper.getGoodsById(stand.getGoods_id());
		stand.setMarket_price(goods.getMarket_price());
		stand.setMid_user_price(goods.getMid_user_price());
		stand.setReal_price(goods.getReal_price());
		return this.standMapper.addStand(stand);
	}

	public boolean deleteStandById(long id) {
		// TODO Auto-generated method stub
		return this.standMapper.deleteStandById(id);
	}

	public Stand getStandById(long id) {
		// TODO Auto-generated method stub
		return this.standMapper.getStandById(id);
	}

	public boolean updateStand(Stand stand) {
		// TODO Auto-generated method stub
		Goods goods=this.goodsMapper.getGoodsById(stand.getGoods_id());
		stand.setMarket_price(goods.getMarket_price());
		stand.setMid_user_price(goods.getMid_user_price());
		stand.setReal_price(goods.getReal_price());
		return this.standMapper.updateStand(stand);
	}

}
