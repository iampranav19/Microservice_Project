package com.pranav.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "Product-Service/product")
public interface ProductService {

	@PutMapping("reduceQuantity/{id}/{quantity}")
	ResponseEntity<Void> reduceQuantity(@PathVariable long id, @PathVariable long quantity);
	
	
	default void fallback(Exception e)
	{
		throw new RuntimeException("Product service is not working ");
	}

}
