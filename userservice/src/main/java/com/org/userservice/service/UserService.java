package com.org.userservice.service;

import java.util.List;

import com.org.userservice.entity.User;

public interface UserService {
	
	User saveUser(User user);
	List<User> getAllUsers();
	User getUser(String id);
	void deleteUser(String id);
	User updateUser(String id,User user);
}
