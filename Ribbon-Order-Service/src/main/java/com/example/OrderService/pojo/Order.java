package com.example.OrderService.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
@Table(name= "ordertable")
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int quantity;
	
	private Double totalPrice;
	
	private int NoofVarieties;
	
	private String username;
	
	//private LocalDate date;
	
}
