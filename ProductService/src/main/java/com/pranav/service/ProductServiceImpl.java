package com.pranav.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.entities.Product;
import com.pranav.exception.ProductServiceCustomException;
import com.pranav.model.ProductRequest;
import com.pranav.model.ProductResponse;
import com.pranav.repositories.ProductRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public long addProduct(ProductRequest productRequest) {
		System.out.println(" +++++++++ Saving theProduct :"+productRequest);
		Product product=new Product();
		
		product.setProductName(productRequest.getProductName());
		product.setPrice(productRequest.getPrice());
		product.setQuantity(productRequest.getQuantity());
		
		Product savedProduct = productRepository.save(product);
		System.out.println("++++++++ Product Created +++++++++++");
		return savedProduct.getProductId();
	}

	@Override
	public ProductResponse getProductById(long id) {
		// TODO Auto-generated method stub
		 Product product = productRepository.findById(id).orElseThrow(()-> new ProductServiceCustomException(" No Product Found with Id::::"+id));
		 ProductResponse response=new ProductResponse();
		 BeanUtils.copyProperties(product, response);
		 return response;
	}

	@Override
	public void reduceQuantity(long id, long quantity) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id).orElseThrow(()-> new ProductServiceCustomException("No Product with the Id"+id));
		if(product.getQuantity()<quantity)
		{
			throw new ProductServiceCustomException("Product Doesn't have Sufficent Quanity max you can order is "+product.getQuantity());
		}
		product.setQuantity(product.getQuantity()-quantity);
		productRepository.save(product);
		System.out.println("++++++++ Product Quantity Updaed Successfully ++++++++++++");
	}

	

}
