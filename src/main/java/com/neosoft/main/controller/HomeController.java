package com.neosoft.main.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.main.model.User;
import com.neosoft.main.service.ServiceInterface;

@CrossOrigin("*")
@RestController
@Validated
public class HomeController {

	@Autowired
	ServiceInterface serviceIntf;

//This URL is used to register user in database	
	@PostMapping("/registerUser")
	public String registerUser(@Valid @RequestBody User user)
	{
		System.out.println(user.getDob());
		serviceIntf.registerUser(user);
		return "User Registered Successfully";
	}

//This URL is used to hard delete user from database	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		serviceIntf.deleteUser(id);
		return "User deleted successfully";
	}

//This URL is used to edit existing user from database	
	@PutMapping("/editUser")
	public User editUser(@RequestBody User user)
	{
		User updatedUser=serviceIntf.editUser(user);
		return updatedUser;
	}

//This URL is used to find user by using name or surname or pin-code from database.	//Note:- It return all data including soft.	
	@GetMapping("/findUser/{input}")
	public List<User> findUser(@PathVariable("input") String input)
	{
		List<User> user=serviceIntf.findUser(input);
		return user;
	}

//This URL is used to soft delete user from database. //Note:- It return existing data except soft and hard deleted.	
	@DeleteMapping("/softDeleteUser/{uid}")
	public List<User> softDeleteUser(@PathVariable("uid") int uid)
	{
		List<User> list=serviceIntf.softDeleteUser(uid);
		return list;
	}

//This URL is used to sort user by DOB in ascending order. //Note:- It return all data including soft.	
	@GetMapping("/userByDOB")
	public List<User> userByDOB()
	{
		List<User> list=serviceIntf.userByDOB();
		return list;
	}

//This URL is used to sort user by Joining date in descending order (latest). //Note:- It return all data including soft.	
	@GetMapping("/userByJoiningDate")
	public List<User> userByJoiningData()
	{
		List<User> list=serviceIntf.userByJoiningData();
		return list;
	}
}
