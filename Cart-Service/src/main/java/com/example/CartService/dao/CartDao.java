package com.example.CartService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CartService.pojo.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer>{
	
	List<Cart> findAll();

}
