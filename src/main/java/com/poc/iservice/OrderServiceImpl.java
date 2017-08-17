package com.poc.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dto.OrderDTO;
import com.poc.models.Order;
import com.poc.repositories.OrderRepository;
import com.poc.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void saveOrder(OrderDTO dto) {
		// TODO Auto-generated method stub
		orderRepository.save(new Order(dto.getName(), dto.getLocation(), dto.getProducts()));
	}

	@Override
	public Order getOrderByName(String name) {
		// TODO Auto-generated method stub
		return orderRepository.findByName(name);			
	}

	@Override
	public List<Order> getOrderByLocation(String location) {
		// TODO Auto-generated method stub
		return orderRepository.findByLocationLike(location);
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public void setOrderInfoClaimFlag(int claimflag, Long id) {
		// TODO Auto-generated method stub
		orderRepository.setOrderInfoClaimFlag(claimflag, id);
	}

	@Override
	public void setOrderInfoPaymentFlag(int paymentflag, Long id) {
		// TODO Auto-generated method stub
		orderRepository.setOrderInfoPaymentFlag(paymentflag, id);
	}

}
