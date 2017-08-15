package com.poc.ulam;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.poc.models.Order;
import com.poc.models.Product;
import com.poc.repositories.OrderRepository;
import com.poc.repositories.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UlamApplicationTests {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Test
	public void contextLoads() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("KARE KARE", 25));
		products.add(new Product("CHICKEN", 25));
		Order order = new Order("JOHN RYAN","NETPARK",products);
		
		orderRepository.save(order);
		
		productRepository.setProductInfoById("DINUGUAN",25,1L);
		for(Product p:productRepository.findAll()){
			System.out.println(p.toString());
		}
	}

}
