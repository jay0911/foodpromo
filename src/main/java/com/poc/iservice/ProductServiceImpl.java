package com.poc.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.dto.ProductDTO;
import com.poc.models.Product;
import com.poc.repositories.ProductRepository;
import com.poc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		productRepository.save(new Product(dto.getName(),dto.getPrice(), dto.getDate()));
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
}
