
package com.neosoft.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.neosoft.main.model.User;
import com.neosoft.main.repository.UserRepo;
import com.neosoft.main.serviceImpl.ServiceImpl;

@SpringBootTest
class ApplicationTests {

	@Autowired
	ServiceImpl serviceImpl;

	@MockBean
	UserRepo userRepo;

	@Test
	public void registerUserTest() {
		User user = new User();
		user.setName("Vrushabh");
		user.setSurname("Manatkar");
		user.setCity("Washim");
		user.setPincode("234322");
		user.setMobileNo("9209459266");
		Date dob = new GregorianCalendar(1995, 12, 12).getTime();
		user.setDob(dob);
		Date joiningDate = new GregorianCalendar(2019, 11, 03).getTime();
		user.setJoiningDate(joiningDate);
		user.setPanNo("CHAPD000M");
		user.setSalary("41000");

		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, serviceImpl.registerUser(user));
		assertNotNull(user);
		System.out.println(user);

	}
	@Test
	public void deleteUserTest() {
		int uid = 2;
		userRepo.deleteById(uid);
		verify(userRepo, times(1)).deleteById(uid);
	}
	@Test
	public void editUserTest() {
		User user = new User();
		user.setId(2);
		user.setName("Vrushabh");
		user.setSurname("Manatkar");
		user.setCity("Washim");
		user.setPincode("234322");
		user.setMobileNo("9209459266");
		Date dob = new GregorianCalendar(1995, 12, 12).getTime();
		user.setDob(dob);
		Date joiningDate = new GregorianCalendar(2019, 11, 03).getTime();
		user.setJoiningDate(joiningDate);
		user.setPanNo("CHAPD000M");
		user.setSalary("41000");

		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, serviceImpl.registerUser(user));
		assertNotNull(user);
		System.out.println(user);
	}
	@Test
	public void findUserTest() {
		User user1 = new User();
		user1.setName("Vrushabh");
		user1.setSurname("Manatkar");
		user1.setCity("Washim");
		user1.setPincode("234322");
		user1.setMobileNo("9209459266");
		Date dob = new GregorianCalendar(1995, 12, 12).getTime();
		user1.setDob(dob);
		Date joiningDate = new GregorianCalendar(2019, 11, 03).getTime();
		user1.setJoiningDate(joiningDate);
		user1.setPanNo("CHAPD000M");
		user1.setSalary("41000");

		User user2 = new User();
		user2.setName("Roshan");
		user2.setSurname("Jadhav");
		user2.setCity("Washim");
		user2.setPincode("234322");
		user2.setMobileNo("9623769194");
		Date dob2 = new GregorianCalendar(1996, 06, 12).getTime();
		user2.setDob(dob2);
		Date joiningDate2 = new GregorianCalendar(2021, 11, 03).getTime();
		user2.setJoiningDate(joiningDate2);
		user2.setPanNo("CHAPD1639M");
		user2.setSalary("45000");

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		String input = "Roshan";
		String deleted="No";

		when(userRepo.findByName(input,deleted)).thenReturn(userList);
		assertEquals(userList, serviceImpl.findUser(input));
	}
	@Test
	public void softDeleteTest() {
		User user1 = new User();
		user1.setName("Vrushabh");
		user1.setSurname("Manatkar");
		user1.setCity("Washim");
		user1.setPincode("234322");
		user1.setMobileNo("9209459266");
		Date dob = new GregorianCalendar(1995, 12, 12).getTime();
		user1.setDob(dob);
		Date joiningDate = new GregorianCalendar(2019, 11, 03).getTime();
		user1.setJoiningDate(joiningDate);
		user1.setPanNo("CHAPD000M");
		user1.setSalary("41000");

		User user2 = new User();
		user2.setName("Roshan");
		user2.setSurname("Jadhav");
		user2.setCity("Washim");
		user2.setPincode("234322");
		user2.setMobileNo("9623769194");
		Date dob2 = new GregorianCalendar(1996, 06, 12).getTime();
		user2.setDob(dob2);
		Date joiningDate2 = new GregorianCalendar(2021, 11, 03).getTime();
		user2.setJoiningDate(joiningDate2);
		user2.setPanNo("CHAPD1639M");
		user2.setSalary("45000");

		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		
		int uid=2;
		String status = "Yes";
		userRepo.saveById(uid, status);
		verify(userRepo, times(1)).saveById(uid, status);

		String status2="No";
		when(userRepo.findAll(status2)).thenReturn(userList);
		assertEquals(userList, serviceImpl.softDeleteUser(uid));

		System.out.println(userList);
	}
	@Test
	public void userByDOBTest()
	{
		ArrayList< User> userList=new ArrayList<>();
		when(userRepo.findAll()).thenReturn(userList);
		assertEquals(userList, serviceImpl.userByDOB());
	}
	@Test
	public void userJoiningDataTest()
	{
		ArrayList< User> userList=new ArrayList<>();
		when(userRepo.findAll()).thenReturn(userList);
		assertEquals(userList, serviceImpl.userByJoiningData());
	}
}
