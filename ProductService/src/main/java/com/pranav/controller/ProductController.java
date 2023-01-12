package com.pranav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.entities.Product;
import com.pranav.model.ProductRequest;
import com.pranav.model.ProductResponse;
import com.pranav.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/add")
	public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
		return new ResponseEntity<Long>(productService.addProduct(productRequest), HttpStatus.CREATED);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<ProductResponse> getProduct(@PathVariable long id)
	{
		return new ResponseEntity<ProductResponse>(productService.getProductById(id),HttpStatus.OK);
	}
	@PutMapping("/reduceQuantity/{id}/{quantity}")
	public ResponseEntity<Void> reduceQuantity(@PathVariable long id, @PathVariable long quantity)
	{
		productService.reduceQuantity(id,quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
