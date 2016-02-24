package com.demo.web.utils;

public class Login_status {
	private String login_key;
	private long user_id;
	private long login_time;
	
	public Login_status(){
		
	}
	
	public Login_status(String key, long user_id, long time) {
		this.login_key = key;
		this.user_id = user_id;
		this.login_time = time;
	}
	
	public String getKey() {
		return login_key;
	}
	public void setKey(String key) {
		this.login_key = key;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public long getTime() {
		return login_time;
	}
	public void setTime(long time) {
		this.login_time = time;
	}
	
	
}
