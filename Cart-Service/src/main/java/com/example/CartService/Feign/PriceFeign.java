package com.example.CartService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "price", url = "http://localhost:8082/api")
public interface PriceFeign {

	@GetMapping("/priceByproductId/{id}")
	public Double findPriceByProductCatalog(@PathVariable("id") int id);
	
}