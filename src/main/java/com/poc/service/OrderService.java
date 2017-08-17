package com.poc.service;

import java.util.List;

import com.poc.dto.OrderDTO;
import com.poc.models.Order;

public interface OrderService {
	public void saveOrder(OrderDTO dto);
	public Order getOrderByName(String name);
	public List<Order> getOrderByLocation(String location);
	public List<Order> getAllOrder();
	

	void setOrderInfoClaimFlag(int claimflag,Long id);
	void setOrderInfoPaymentFlag(int paymentflag,Long id);
}
