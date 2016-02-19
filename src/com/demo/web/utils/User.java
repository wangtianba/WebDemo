package com.demo.web.utils;


public class User {
	private String name;
	private String password;
	private String phone;
	private String info;
	private int type;
	
	public User(String name, String password, String phone, String info, int type) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.info = info;
		this.type = type;
	}

	public User() {
		super();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
}
