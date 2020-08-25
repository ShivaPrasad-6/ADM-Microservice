package com.example.CartService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CartService.Feign.PriceFeign;
import com.example.CartService.pojo.Cart;
import com.example.CartService.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private PriceFeign priceFeign;
	
	
	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		return cartService.getAllCarts();
	}
	
	
	@PostMapping("/cart/shiva")
	public Cart saveCart(@RequestBody Cart cart) {
		if(cart.getItem().getPrice() == null) {
			Double price = priceFeign.findPriceByProductCatalog(cart.getItem().getId());
			cart.getItem().setPrice(price);	
		}
		
		return cartService.saveCart(cart);
	}
	
	@GetMapping("/totalprice")
	public Double TotalPrice() {
		return cartService.Totalprice();
	}
	
	@GetMapping("/totalqty")
	public int Totalqty() {
		return cartService.Totalqty();
	}
	
	@GetMapping("/noofVarieties")
	public int NoofVarieties() {
		return cartService.NoofVarieties();
	}
	
	@DeleteMapping("/deletecart")
	public void DeleteCart() {
		cartService.Delete();
	}
	

}
