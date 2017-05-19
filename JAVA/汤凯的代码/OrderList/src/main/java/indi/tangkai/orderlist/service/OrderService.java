package indi.tangkai.orderlist.service;

import java.util.List;

import indi.tangkai.orderlist.data.entity.Order;
import indi.tangkai.orderlist.data.entity.SearchOrder;

public interface OrderService {
	public List<Order> getAllOrder();
	public Order getOrderByOrderId(long order_id);
	public void updateOrder(Order order);
	public List<Order> searchOrder(SearchOrder searchOrder);
	}
