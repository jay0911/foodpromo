package com.poc.repositories;

import org.springframework.data.repository.CrudRepository;

import com.poc.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

}
