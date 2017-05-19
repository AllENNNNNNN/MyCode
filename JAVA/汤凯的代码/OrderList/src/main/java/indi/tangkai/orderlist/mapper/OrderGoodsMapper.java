package indi.tangkai.orderlist.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import indi.tangkai.orderlist.data.entity.Order;
import indi.tangkai.orderlist.data.entity.OrderGoods;

//@Repository用于标注数据访问组件，即DAO组件；
@Repository
public interface OrderGoodsMapper {
	public List<OrderGoods> getAllGoodsByOrderId(long order_id);
}
