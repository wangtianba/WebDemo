package com.demo.web.utils;

import com.demo.web.utils.User;

public interface UserMapper {
	public void insertUser(User user);

	public User getUserByName(String name);
	
	public User getUserById(long id);
}
