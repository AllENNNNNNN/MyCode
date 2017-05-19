package indi.tangkai.orderlist.service;

import java.util.List;

import indi.tangkai.orderlist.data.entity.OrderGoods;

public interface OrderGoodsService {
	public List<OrderGoods> getAllOrdersByOrderId(long order_id);
}
