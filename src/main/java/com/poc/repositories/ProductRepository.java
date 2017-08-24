package com.poc.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.poc.models.Product;
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findByName(String name);
	List<Product> findAll();
	
	Long deleteById(Long id);
	
	@Modifying
	@Query("update Product p set p.name = ?1, p.price = ?2 where p.id = ?3")
	void setProductInfoById(String name, int price, Long id);
}
