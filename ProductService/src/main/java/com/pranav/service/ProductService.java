package com.pranav.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pranav.entities.Product;
import com.pranav.model.ProductRequest;
import com.pranav.model.ProductResponse;

@Repository
public interface ProductService  {

	public long addProduct(ProductRequest productRequest);

	public ProductResponse getProductById(long id);

	public void reduceQuantity(long id, long quantity);

	
}
