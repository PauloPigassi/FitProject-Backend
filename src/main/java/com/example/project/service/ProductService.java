package com.example.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProduct() {
		return productRepository.findAll();
	}
	
	public ResponseEntity<Product> getProductById(Integer id){
		 Optional<Product> productService = productRepository.findById(id);
	        if(productService.isPresent())
	            return new ResponseEntity<Product>(productService.get(), HttpStatus.OK);
	        else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public ResponseEntity<Product> updateProduct(Product product){
		Optional<Product> oldProduct = productRepository.findById(product.getProductId());
        if(oldProduct.isPresent()){
            Product productService = oldProduct.get();
            productService.setName(product.getName());
            productService.setBrand(product.getBrand());
            productService.setPrice(product.getPrice());
            productService.setQuantity(product.getQuantity());

            productRepository.save(productService);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<Object> deleteProduct(Integer id){
		Optional<Product> productService = productRepository.findById(id);
        if(productService.isPresent()){
            productRepository.delete(productService.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
