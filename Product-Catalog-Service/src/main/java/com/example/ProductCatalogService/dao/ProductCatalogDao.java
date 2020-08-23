package com.example.ProductCatalogService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductCatalogService.pojo.ProductCatalog;


@Repository
public interface ProductCatalogDao extends CrudRepository<ProductCatalog, Integer> {
	
	List<ProductCatalog> findAll();
	
	 public List<ProductCatalog> findByproductName(String productName);
	 
	 @Query("SELECT p FROM ProductCatalog p WHERE p.productName LIKE %?1%")
	 public List<ProductCatalog> findByProductLike(String productName);
	
}
