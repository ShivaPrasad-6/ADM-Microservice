package com.example.OrderService.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.OrderService.Ribbon.RibbonConfiguration;
import com.example.OrderService.pojo.Order;
import com.example.OrderService.service.OrderService;

@RestController
@RequestMapping("/api")
//@RibbonClient(name = "price", configuration = RibbonConfiguration.class)
public class OrderController {

//	@Autowired
//	private RestTemplate template;
//	
	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping("/orders/shiva")
	public Order savepc(@RequestBody Order order) {
		return orderService.save(order);
	}


//	@GetMapping("/invoke")
//	public String invokeprice() {
//		String url= "http://price/api/price";
//		return template.getForObject(url, String.class);
//	}
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate template() {
//		return new RestTemplate();
//	}
	
	
}
