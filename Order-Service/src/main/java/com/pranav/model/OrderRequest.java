package com.pranav.model;


public class OrderRequest {

	private long productId;
	private long quantity;
	private long amount;
	private PaymentMode paymentMode;
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public OrderRequest(long productId, long quantity, long amount, PaymentMode paymentMode) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.paymentMode = paymentMode;
	}
	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
