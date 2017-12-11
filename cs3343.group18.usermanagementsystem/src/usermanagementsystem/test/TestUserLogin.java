package usermanagementsystem.test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import usermanagementsystem.user_login.*;
import usermanagementsystem.datastructure_interface.ISupervisorInfo;
import usermanagementsystem.datastructure_interface.IUserInfo;
import usermanagementsystem.controller.AdminController;
import usermanagementsystem.controller.IController;
import usermanagementsystem.dataaccess.UserDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumGender;
import usermanagementsystem.datastructure.EnumPosition;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.controller.UserController;
import usermanagementsystem.controller.SupervisorController;

public class TestUserLogin {

	@Test
	public void test_UserLogin01() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean isLoggedIn = user.getLoginStatus();
		assertEquals(false, isLoggedIn);
	}
	
	@Test
	public void test_UserLogin02() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("abc", "99");
		assertNotNull(login);
		assertTrue(login instanceof UserController);
	}
	
	@Test
	public void test_UserLogin03() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("admin", "123");
		assertNotNull(login);
		assertTrue(login instanceof AdminController);
	}
	
	@Test
	public void test_UserLogin04() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("efg", "666");
		assertNotNull(login);
		assertTrue(login instanceof SupervisorController);
	}
	
	@Test
	public void test_UserLogin05() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("efg", "");
		assertEquals(null, login);
	}
	
	@Test
	public void test_UserLogin06() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("", "");
		assertEquals(null, login);
	}
	
	@Test
	public void test_UserLogin07() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login(null, null);
		assertEquals(null, login);
	}
	
	@Test
	public void test_UserLogin08() throws Exception {
		UserLogin user = UserLogin.getInstance();
		user.logoutProcess();
		boolean status = user.getLoginStatus();
		assertEquals(false, status);
	}
	
	@Test
	public void test_UserLogin09() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String name = user.getLoggedInUsername();
		assertEquals("", name);
	}
	
	@Test
	public void test_UserLogin10() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IController login = user.login("admin", "123");
		String name = user.getLoggedInUsername();
		assertEquals("admin", name);
	}

}
