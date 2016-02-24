package com.demo.web.utils;

public interface Login_status_Mapper {

	public void insertLogin_status(Login_status login_status);

	public Login_status getLogin_status(String key);
	
	public void deleteLogin_status(String key);
	
	public void updateLogin_status(Login_status login_status);
}
