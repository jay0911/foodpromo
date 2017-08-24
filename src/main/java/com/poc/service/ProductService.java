package com.poc.service;

import java.util.List;

import com.poc.dto.ProductDTO;
import com.poc.models.Product;

public interface ProductService {
	public void addProduct(ProductDTO dto);
	public void deleteProduct(Long id);
	public void editProduct(Product product);
	public List<Product> getAllProduct();
}
