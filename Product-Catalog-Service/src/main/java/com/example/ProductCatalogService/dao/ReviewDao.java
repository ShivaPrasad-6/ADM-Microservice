package com.example.ProductCatalogService.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductCatalogService.pojo.Review;

@Repository
public interface ReviewDao extends CrudRepository<Review, Integer> {
	
	List<Review> findAll();

	List<Review> findByProductId(int id);
	
}
