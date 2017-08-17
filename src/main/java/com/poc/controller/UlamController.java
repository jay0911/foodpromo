package com.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.dto.ProductDTO;
import com.poc.models.Product;
import com.poc.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value="url for product", description="This is the endpoint for getting the information/adding info for product.")
@RequestMapping("/product")
public class UlamController {
	
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "Saves the product details",
		    notes = "saves the product details to db")
	@PostMapping("/saveProduct")
	public void saveProduct(@ApiParam(value = "Product dto object that the properties of that object must be filled in", required = true) @RequestBody ProductDTO dto) {
		productService.addProduct(dto);
	}
	
	@ApiOperation(value = "Get all product info",
		    notes = "Get all product info that the customer will use to select product",
		    response = Product.class,
		    responseContainer = "List")	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}
}
