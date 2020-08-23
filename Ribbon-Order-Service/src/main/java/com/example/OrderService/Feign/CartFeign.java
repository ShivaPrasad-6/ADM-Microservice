package com.example.OrderService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cart", url = "http://localhost:8083/api")
public interface CartFeign {
	
	@GetMapping("/totalprice")
	public Double TotalPrice();
	
	@GetMapping("/totalqty")
	public  int Totalqty();
	
	@GetMapping("/noofVarieties")
	public int NoofVarieties();
	
}
