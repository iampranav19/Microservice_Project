package com.pranav.model;

public class ProductResponse {

	@Override
	public String toString() {
		return "ProductResponse [productName=" + productName + ", price=" + price + ", quantity=" + quantity + "]";
	}
	private String productName;
	private long price;
	private long quantity;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public ProductResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductResponse(String productName, long price, long quantity) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	 
}
