package com.example.ProductCatalogService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductCatalogService.dao.ProductCatalogDao;
import com.example.ProductCatalogService.dao.ReviewDao;
import com.example.ProductCatalogService.pojo.ProductCatalog;
import com.example.ProductCatalogService.pojo.Review;

@Service
public class ProductCatalogService {
	
	@Autowired
	private ProductCatalogDao productCatalogDao;

	@Autowired
	private ReviewDao rdao;
	
	public List<ProductCatalog> getAllProducts() {
		return productCatalogDao.findAll();
	}
	
	public List<Review> getReviews(){
		return rdao.findAll();
	}
	
	public Optional<ProductCatalog> findProductById(Integer id) {
		Optional<ProductCatalog> product = productCatalogDao.findById(id);
		return Optional.ofNullable(product.get());
	}
	
	public List<ProductCatalog> findProductByName(String productName) {
		List<ProductCatalog> product = productCatalogDao.findByproductName(productName);
		return product;
	}

	public ProductCatalog save(ProductCatalog pc) {
		return productCatalogDao.save(pc);
	}
	
	public List<ProductCatalog> saveProductCatalogs(List<ProductCatalog> productCatalogs) {
		return (List<ProductCatalog>) productCatalogDao.saveAll(productCatalogs);
	}
	
	public List<ProductCatalog> getByLetter(String productName){
        return productCatalogDao.findByProductLike("e");
	}
	
	
	public Review addReview(int id, Review review) {
		Optional<ProductCatalog> p = productCatalogDao.findById(id);
		review.setProduct(p.get());
		 Review newreview = rdao.save(review);
		return newreview;
	}
	
	public List<Review> findReviewByProductCatalog(int id) {	
		 return rdao.findByProductId(id);
	}
	
	public Double findPriceByProductCatalog(int id) {	
		Optional<ProductCatalog> product = productCatalogDao.findById(id);
		ProductCatalog pc = product.get();
		return pc.getProductPrice();
	}
	
}
