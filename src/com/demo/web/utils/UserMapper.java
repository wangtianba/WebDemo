package com.demo.web.utils;

import com.demo.web.utils.User;

public interface UserMapper {
	public void insertUser(User user);

	public User getUser(String name);
}
