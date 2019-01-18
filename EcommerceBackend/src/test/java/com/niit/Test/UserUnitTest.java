package com.niit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.EcommerceBackend.dao.UserDao;
import com.niit.EcommerceBackend.model.User;

public class UserUnitTest {

	static UserDao userDao;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDao = (UserDao) context.getBean("userDao");
	}

	@Test
	public void test() {
		User user = new User();
		user.setUsername("swathi");
		user.setPassword("swathi@123");
		user.setEnabled(true);

		user.setCustomerName("swathi vijay Kumar");
		user.setCustomerAddr("bangalore");
		boolean res = userDao.registerUser(user);
		assertEquals("problem in inserting  the data", true, res);

	}

	@Ignore
	@Test
	public void insertUser() {
		User user = new User();
		user.setUsername("karthik5");
		user.setPassword("praneeth@123");
		user.setEnabled(true);
		user.setCustomerName("Vinod Kumar");
		user.setCustomerAddr("Kumbakonam");
		// boolean res=userDao.registerUser(user);
		// System.out.println("result is "+res);
		assertTrue("problem in inserting  the data", userDao.registerUser(user));
		// asse("insertion is done successfully",true,res);

	}

	@Ignore
	@Test
	public void insertUser1() {
		User user = new User();
		user.setUsername("jayaram");
		user.setPassword("jayaram@123");
		user.setEnabled(true);

		user.setCustomerName("Vinod Kumar");
		user.setCustomerAddr("Kumbakonam");
		boolean res = userDao.registerUser(user);
		System.out.println("result is " + res);
		assertEquals("problem in inserting  the data", true, res);
		// asse("insertion is done successfully",true,res);

	}

	@Ignore
	@Test
	public void listUsers() {
		User user = new User();
		List<User> list = userDao.listUser();
		System.out.println("list size is " + list.size());
		assertEquals("problem in getting list ", 3, list.size());
		System.out.println("test case is passed successfully");
		for (User l : list) {
			System.out.println(l.getUsername() + l.getCustomerAddr() + l.getPassword());
		}

	}

	@Ignore
	@Test
	public void getUser() {
		User user = userDao.getUserByUserName(70);
		assertEquals("problem in getting the student info", "12345", user.getPassword());
	}

	@Ignore
	@Test
	public void updateUser() {
		User user = userDao.getUserByUserName(70);
		user.setPassword("sowmya@123");

		userDao.updateUser(user);
		assertEquals("problem in updating the user", "sowmya@123", user.getPassword());
	}

	@Ignore
	@Test
	public void deleteUser() {
		User usr = userDao.getUserByUserName(70);
		userDao.deleteUser(usr);
		assertEquals("problem in getting the list", 2, userDao.listUser().size());
		System.out.println("deletion of user is done successfully");
	}

}
