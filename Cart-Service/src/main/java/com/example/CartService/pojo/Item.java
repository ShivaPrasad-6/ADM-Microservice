package com.example.CartService.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name= "item")
public class Item{
	
	@Id
	private int id;
	private String productName;
	private Double price;
	private Double totalPrice; 
	
}
