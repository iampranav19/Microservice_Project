package com.pranav.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("PAYMENT-Service/payment")
public interface PaymentService {

	@PostMapping("/pay")
	public ResponseEntity<Long> doPayament(@RequestBody PaymentRequest paymentRequest);
}
