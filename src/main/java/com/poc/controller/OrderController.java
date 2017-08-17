package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dto.OrderDTO;
import com.poc.models.Order;
import com.poc.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="url for orders", description="This is the endpoint for getting the information/adding info for orders can only accessed by all")
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value = "Saves the order of customer",
			    notes = "order consist of info of customer and products")
	@PostMapping("/saveOrder")
	public void saveOrder(@ApiParam(value = "Order dto object that the properties of that object must be filled in", required = true) @RequestBody OrderDTO dto) {
		orderService.saveOrder(dto);
	}
	
	@ApiOperation(value = "Get all order info by location",
			    notes = "all the order that has certain location will be displayed",
			    response = Order.class,
			    responseContainer = "List")
	@GetMapping("/getOrderByLocation")
	public List<Order> getOrderByLocation(@ApiParam(value = "location string and will be use for like condition in query") @RequestParam(value = "location") String location){
		return orderService.getOrderByLocation(location);
	}
	
	@ApiOperation(value = "Get all orders",
		    notes = "all the orders will be displayed",
		    response = Order.class)
	@GetMapping("/getOrderByName")
	public Order getOrderByName(@ApiParam(value = "name string and will be use for condition in query") @RequestParam(value = "name") String name){
		return orderService.getOrderByName(name);
	}
	
	@ApiOperation(value = "Get all order info by location",
		    notes = "all the order that has certain location will be displayed",
		    response = Order.class,
		    responseContainer = "List")
	@GetMapping("/getAllOrder")
	public List<Order> getAllOrder(){
		return orderService.getAllOrder();
	}
	
	@PostMapping("/setOrderInfoClaimFlag")
	public void setOrderInfoClaimFlag(
			@RequestParam(value = "claimflag", required = true) int claimflag,
			@RequestParam(value = "id", required = true) Long id) {
		orderService.setOrderInfoClaimFlag(claimflag, id);
	}
	
	@PostMapping("/setOrderInfoPaymentFlag")
	public void setOrderInfoPaymentFlag(
			@RequestParam(value = "paymentflag", required = true) int paymentflag,
			@RequestParam(value = "id", required = true) Long id) {
		orderService.setOrderInfoPaymentFlag(paymentflag, id);
	}
}
