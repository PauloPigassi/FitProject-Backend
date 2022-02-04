package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import com.example.project.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    public List<Product> Get() {
        return productService.getProduct();
    }
    
    @RequestMapping(value = "/findProduct/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> GetById(@PathVariable(value = "id") int id)
    {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/createProduct", method =  RequestMethod.POST)
    public Product Post(@Valid Product product)
    {
    	product.setBrand("Apple");
    	product.setName("Iphone");
    	product.setQuantity(10);
    	product.setPrice(10000);
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/updateProduct/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Product> Put(@PathVariable(value = "id") int id, @Valid Product newProduct)
    {
    	newProduct.setBrand("Apple");
    	newProduct.setName("Iphone");
    	newProduct.setQuantity(10);
    	newProduct.setPrice(10000);
        
    	return productService.updateProduct(newProduct);
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
    	return productService.deleteProduct(id);
    }
}

