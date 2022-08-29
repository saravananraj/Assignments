package com.saravanan.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saravanan.springcloud.model.Product;
import com.saravanan.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	
	@PostMapping(value = "/products")
	public Product create(@RequestBody Product product) {
		
		return productRepo.save(product);
	}
	
	
}
