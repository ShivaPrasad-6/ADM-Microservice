package com.example.ProductCatalogService.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
@Entity
@Table(name= "productCatalog")
public class ProductCatalog {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String productName;
	private double productPrice;
	private String description;
	
}
