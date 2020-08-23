package com.example.PriceService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PriceService.Feign.ProductFeign;

@Service
public class PriceService {
	
//	@Autowired
//	private PriceDao priceDao;
	
	@Autowired
	ProductFeign productFeign;
	
	public Double findPriceByProductCatalog(int id) {	
		return productFeign.getPriceByProductCatalog(id);
	}
	
//	
//	public List<Price> getAllPrices() {
//		return priceDao.findAll();
//	}
//	
//	public Price savePrice(Price price) {
//		return priceDao.save(price);
//	}
	

}
