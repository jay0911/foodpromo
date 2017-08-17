package com.poc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.poc.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
	Order findByName(String name);
	List<Order> findByLocationLike(String location);
	List<Order> findAll();
	
	@Modifying
	@Query("update Order o set o.claimflag = ?1 where o.id = ?2")
	void setOrderInfoClaimFlag(int claimflag,Long id);
	
	@Modifying
	@Query("update Order o set o.paymentflag = ?1 where o.id = ?2")
	void setOrderInfoPaymentFlag(int claimflag,Long id);
	
}
