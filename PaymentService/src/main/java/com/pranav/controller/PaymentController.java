package com.pranav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;
import com.pranav.model.PaymentRequest;
import com.pranav.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/pay")
	public ResponseEntity<Long> doPayament(@RequestBody PaymentRequest paymentRequest)
	{
		return new ResponseEntity<Long>(paymentService.doPayment(paymentRequest),HttpStatus.CREATED);
	}
}
