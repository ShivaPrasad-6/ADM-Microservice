package com.example.CartService.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.CartService.pojo.Item;

public interface ItemDao extends CrudRepository<Item, Integer>{

}
