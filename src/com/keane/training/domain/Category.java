package com.keane.training.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int categoryId;
	private String categoryName;
	private List<Product> product = new ArrayList<Product>();
	public Category(int categoryId, String categoryName, List<Product> product) {
	
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.product = product;
	}
	public Category(int categoryId, String categoryName) {
		
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		
	}
	public Category() {
		
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return ("categoryId=" + categoryId + ", categoryName=" + categoryName + ", product=" + product);
	}
	
	
}
