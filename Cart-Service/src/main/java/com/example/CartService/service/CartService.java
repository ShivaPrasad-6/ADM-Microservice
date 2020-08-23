package com.example.CartService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CartService.dao.CartDao;
import com.example.CartService.dao.ItemDao;
import com.example.CartService.pojo.Cart;

@Service
public class CartService {
	
	public static Double totalprizecount = 0.0;
	public static int qtycount = 0;
	public static int noofvarieties = 0;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ItemDao itemDao;
	
	public List<Cart> getAllCarts() {
		return cartDao.findAll();
	}
	
	public Cart saveCart(Cart cart){ 
		if(cart.getItem().getTotalPrice() == null) {
			Double totalprice = cart.getQty()*cart.getItem().getPrice();
			cart.getItem().setTotalPrice(totalprice);
		}
		totalprizecount = totalprizecount + cart.getItem().getTotalPrice(); 
		qtycount = qtycount + cart.getQty(); 
		noofvarieties++;
		cartDao.save(cart);
		return cart;
	}
	
	public Double Totalprice() {
		return totalprizecount;
	}
	
	public int Totalqty() {
		return qtycount;
	}
	
	public int NoofVarieties() {
		return noofvarieties;
	}
	
	public void Delete() {
		cartDao.deleteAll();
		itemDao.deleteAll();
	}
}
