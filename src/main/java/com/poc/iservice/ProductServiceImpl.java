package com.poc.iservice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poc.dto.ProductDTO;
import com.poc.models.Product;
import com.poc.repositories.ProductRepository;
import com.poc.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public void addProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		logInfo("------saving product");
		productRepository.save(new Product(dto.getName(),dto.getPrice(), dto.getDate()));
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		logInfo("------deleting product");
		productRepository.deleteById(id);
	}

	@Override
	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		logInfo("------editing product");
		productRepository.setProductInfoById(product.getName(), product.getPrice(), product.getId());
	}
	
	private static void logInfo(String msg){
		if(LOGGER.isInfoEnabled()){
			LOGGER.info(msg);
		}
	}
}
