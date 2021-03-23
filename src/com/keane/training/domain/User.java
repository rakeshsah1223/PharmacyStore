package com.keane.training.domain;

public class User {
	private int userId;
	private String pass;
	private String emailId;
	private int age;
	private long contact;
	private String city;
	private String state;
	private int pincode;
	private String role_type;
	private String name;
	public User(int userId,String pass) {
		this.userId = userId;
		this.pass = pass;
	}
	
	public User() {
		
	}
	
	public User(int userId, String pass, String emailId, int age, long contact, String city, String state, int pincode,
			String role_type, String name) {
		
		this.userId = userId;
		this.pass = pass;
		this.emailId = emailId;
		this.age = age;
		this.contact = contact;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.role_type = role_type;
		this.name = name;
	}

	public User(int id, String pass2, String roole_type) {
		// TODO Auto-generated constructor stub
		this.userId = id;
		this.pass=pass2;
		this.role_type=roole_type;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}