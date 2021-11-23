package com.neosoft.main.service;

import java.util.List;
import java.util.Optional;

import com.neosoft.main.model.User;

public interface ServiceInterface {
 
	public User registerUser(User user);
	public void deleteUser(int uid);
	public User editUser(User user);
	public List<User> findUser(String input);
	public List<User> softDeleteUser(int uid);
	public List<User> userByDOB();
	public List<User> userByJoiningData();
	
}
