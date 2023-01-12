package com.pranav.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pranav.entities.Order;
import com.pranav.external.client.PaymentRequest;
import com.pranav.external.client.ProductService;
import com.pranav.model.OrderRequest;
import com.pranav.repo.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private ProductService productService;
	
	@Autowired
	PaymentRequest paymentRequest;

	@Override
	public long placeOrder(OrderRequest orderRequest) {
		// Order Entity -> Save the data with Status Order Created.
		// Product Service -> Block Product (Reduce Quantity)
		// Payment Service --> Payment --> Success (Complete) else -> Cancelled

		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

		System.out.println("++++++++ Placing Order:: " + orderRequest);
		Order order = new Order();
		order.setAmount(orderRequest.getAmount());
		order.setOrderStatus("CREATED");
		order.setProductId(orderRequest.getProductId());
		order.setOrderDate(Instant.now());
		order.setQuantity(orderRequest.getQuantity());

		Order savedOrder = orderRepo.save(order);
		System.out.println("+++++ Order Placed Successfully with " + savedOrder.getId());
		
		paymentRequest.setAmount(orderRequest.getAmount());
		paymentRequest.setOrderId(savedOrder.getId());

		return savedOrder.getId();
	}

}
