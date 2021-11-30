package com.neosoft.main.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.neosoft.main.model.User;
import com.neosoft.main.repository.UserRepo;
import com.neosoft.main.service.ServiceInterface;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	UserRepo userRepo;
	
	String status2 = "No";

	@Override
	public User registerUser(User user) {
		User storedUser = userRepo.save(user);
		return storedUser;
	}

	@Override
	public void deleteUser(int uid) {
		userRepo.deleteById(uid);
	}

	@Override
	public User editUser(User user) {	
		User updatedUser = userRepo.save(user);
		return updatedUser;
	}

	@Override
	public List<User> findUser(String input) {
		List<User> checkUser1 = userRepo.findByName(input,status2);
		if (!checkUser1.isEmpty()) {
			System.out.println("In Service IMPL" + checkUser1);
			return checkUser1;
		} else {
			List<User> checkUser2 = userRepo.findBySurname(input,status2);
			if (!checkUser2.isEmpty()) {
				return checkUser2;
			} else {
				List<User> checkUser3 = userRepo.findByPincode(input,status2);
				return checkUser3;
			}
		}
	}

	@Override
	public List<User> softDeleteUser(int uid) {
		String status1 = "Yes";
		userRepo.saveById(uid, status1);

		
		List<User> list = userRepo.findAll(status2);
		return list;
	}

	@Override
	public List<User> userByDOB() {
		List<User> list = userRepo.findAll(status2);
		List<User> newList = list.stream().sorted((User u1, User u2) -> u1.getDob().compareTo(u2.getDob()))
				.collect(Collectors.toList());
		return newList;
	}

	@Override
	public List<User> userByJoiningData() {
		List<User> list = userRepo.findAll(status2);
		List<User> newList = list.stream()
				.sorted((User u1, User u2) -> u2.getJoiningDate().compareTo(u1.getJoiningDate()))
				.collect(Collectors.toList());
		return newList;
	}
}
