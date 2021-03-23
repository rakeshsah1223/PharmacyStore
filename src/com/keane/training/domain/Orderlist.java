package com.keane.training.domain;

public class Orderlist {
	private int orderId;
	private int uId;
	private int prodId;
	private String requestdate;
	private int qty;
	private double total;
	
	
	
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	private User user;///extra line to debug
	private Product product;
	public Orderlist() {
		
	}
	public Orderlist(User user, int quantity,String requestdate) {
		this.user = user;
		this.qty = quantity;
		this.requestdate = requestdate;
	}
	public Orderlist(int uID,int productId ,String requestdate,int quantity) {
		//this.orderId = orderId;
		this.prodId = productId;
		this.qty = quantity;
		this.uId = uID;
		this.user = user;
		this.requestdate = requestdate;
	}
	public Orderlist(int orderId, int productId, int quantity, int uID,String requestdate) {
		this.orderId = orderId;
		this.prodId = productId;
		this.qty = quantity;
		this.uId = uID;
		this.user = user;
		this.requestdate = requestdate;
	}
	public Orderlist(int orderid2, int qty,int uID) {
		// TODO Auto-generated constructor stub
		this.orderId = orderid2;
		this.qty=qty;
		this.uId = uID;
	}
	
	//......
	public Orderlist(int uid2, Product product) {
		// TODO Auto-generated constructor stub
		this.product = product;
		this.uId = uid2;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getRequestdate() {
		return requestdate;
	}
	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	@Override
	public String toString() {
		return ("orderId=" + orderId + ", uId=" + uId + ", prodId=" + prodId + ", requestdate=" + requestdate
				+ ", qty=" + qty);
	}

	
	
}
