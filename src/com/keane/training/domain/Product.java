package com.keane.training.domain;

public class Product {
	private int productId;
	private String productName;
	private int quantity;
	private double price;
	private int catId;
	
	public Product(int productId, String productName, int quantity, double price, int catId) {
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.catId = catId;
	}
	

	public Product(String pname) {
		// TODO Auto-generated constructor stub
		productName=pname;
	}


	public Product() {
		// TODO Auto-generated constructor stub
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getCatId() {
		return catId;
	}


	public void setCatId(int catId) {
		this.catId = catId;
	}

	

	@Override
	public String toString() {
		return ("prodId=" + productId + ", productName=" + productName +","+ "Quantity=" +quantity+ ", productprice=" + price
				+ ", categoryId=" + catId).toString();
	}
	
}
