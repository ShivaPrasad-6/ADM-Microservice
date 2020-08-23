package com.example.PriceService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PriceService.service.PriceService;



@RestController
@RequestMapping("/api")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping("/priceByproductId/{id}")
	public Double findPriceByProductCatalog(@PathVariable("id") int id) {
		return priceService.findPriceByProductCatalog(id);
	}

//	@GetMapping("/price")
//	public List<Price> getAllPrice() {
//		return priceService.getAllPrices();
//	}
//	
//	@PostMapping("/price")
//	public Price savePrice(@RequestBody Price price) {
//		return priceService.savePrice(price);
//	}
}

