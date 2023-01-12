package com.pranav.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.model.OrderRequest;

public interface OrderService 
{

	public long placeOrder(OrderRequest orderRequest);

	
}
