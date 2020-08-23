package com.example.ProductCatalogService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductCatalogService.pojo.ProductCatalog;
import com.example.ProductCatalogService.pojo.Review;
import com.example.ProductCatalogService.service.ProductCatalogService;

@RestController
@RequestMapping("/api")
public class ProductCatalogController {

	@Autowired
	private ProductCatalogService pcservice;

	@GetMapping("/products")
	public List<ProductCatalog> getAllProducts() {
		return pcservice.getAllProducts();
	}

	@GetMapping("/reviews")
	public List<Review> getAllReviews() {
		return pcservice.getReviews();
	}

	@GetMapping("/products/{id}")
	public Optional<ProductCatalog> findProductById(@PathVariable("id") Integer id) {
		return pcservice.findProductById(id);
	}

	@GetMapping("/products/byname/{productName}")
	public List<ProductCatalog> findProductByName(@PathVariable("productName") String productName) {
		return pcservice.findProductByName(productName);
	}

	@PostMapping("/products")
	public ProductCatalog savepc(@RequestBody ProductCatalog pc) {
		return pcservice.save(pc);
	}

	@PostMapping("/products/all")
	public List<ProductCatalog> saveProductCatalogs(@RequestBody List<ProductCatalog> productCatalogs) {
		return pcservice.saveProductCatalogs(productCatalogs);
	}

	@GetMapping("/products/productname/{productName}")
	public List<ProductCatalog> getProductByNameContainingE(@PathVariable String productName) {
		return pcservice.getByLetter(productName);
	}

	@PostMapping("/{id}/review")
	public Review addReview(@PathVariable int id, @RequestBody Review review) {
		return pcservice.addReview(id, review);
	}

	@GetMapping(path = "/products/{id}/reviews")
	public List<Review> getReviewByProductCatalog(@PathVariable(value = "id") int id) {
		return pcservice.findReviewByProductCatalog(id);
	}

	@GetMapping("/products/price/{id}")
	public Double getPriceByProductCatalog(@PathVariable(value = "id") int id) {
		return pcservice.findPriceByProductCatalog(id);
	}
	
	

}
