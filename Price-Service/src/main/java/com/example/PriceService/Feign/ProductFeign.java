package com.example.PriceService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product", url = "http://localhost:8081/api")
public interface ProductFeign {
	
	@GetMapping("/products/price/{id}")
	public Double getPriceByProductCatalog(@PathVariable(value = "id") int id);
	
}
