package com.poc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.models.Order;
import com.poc.models.Product;
import com.poc.repositories.OrderRepository;
import com.poc.repositories.ProductRepository;

@RestController
public class UlamController {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/check")
	public void check(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("KARE KARE", 25));
		products.add(new Product("CHICKEN", 25));
		Order order = new Order("JOHN RYAN","NETPARK",products);
		
		orderRepository.save(order);
		for(Product p:productRepository.findAll()){
			System.out.println(p.toString());
		}
	}
}
