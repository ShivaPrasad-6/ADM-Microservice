package com.example.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderService.Feign.CartFeign;
import com.example.OrderService.dao.OrderDao;
import com.example.OrderService.pojo.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao odao;
	
	@Autowired
	private CartFeign cartFeign;
	
	public Order save(Order order) {
		if( order.getTotalPrice()==null && order.getNoofVarieties()==0  && order.getQuantity()==0) {
			order.setTotalPrice(cartFeign.TotalPrice());
			order.setQuantity(cartFeign.Totalqty());
			order.setNoofVarieties(cartFeign.NoofVarieties());
		}
		return odao.save(order);
	}
	
}
