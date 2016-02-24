package com.demo.web.utils;


public class User {
	private int id;
	private String user_name;
	private String password;
	private String number;
	private String info;
	private int type;
	
	public User(String name, String password, String number, String info, int type) {
		super();
		this.user_name = name;
		this.password = password;
		this.number = number;
		this.info = info;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String phone) {
		this.number = phone;
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
		return user_name;
	}

	public void setName(String name) {
		this.user_name = name;
	}

	

	
}
