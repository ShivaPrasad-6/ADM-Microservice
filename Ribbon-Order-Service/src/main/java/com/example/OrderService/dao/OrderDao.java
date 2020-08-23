package com.example.OrderService.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.OrderService.pojo.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer>{

}
