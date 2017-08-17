package com.poc.service;

import java.util.List;

import com.poc.dto.ProductDTO;
import com.poc.models.Product;

public interface ProductService {
	public void addProduct(ProductDTO dto);
	public List<Product> getAllProduct();
}
