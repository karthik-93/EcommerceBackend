package com.niit.EcommerceBackend.dao;

import java.util.List;

import com.niit.EcommerceBackend.model.User;

public interface UserDao {
	public boolean registerUser(User user);

	public boolean updateUser(User user);

	public List<User> listUser();
	
	public User getUserByUserName(int userId);
	
	public boolean deleteUser(User user); 
}
