package usermanagementsystem.test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

import usermanagementsystem.user_login.*;
import usermanagementsystem.datastructure_interface.IUserInfo;
import usermanagementsystem.controller.AdminController;
import usermanagementsystem.controller.IController;
import usermanagementsystem.dataaccess.UserDao;
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
		IController login = user.login("james", "104");
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
		boolean userCheck = user.checkUserExist(null);
		assertEquals(false, userCheck);
	}
	
	@Test
	public void test_UserLogin08() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean userCheck = user.checkUserExist("abc");
		assertEquals(true, userCheck);
	}
	
	/*@Test
	public void test_UserLogin08() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("y");
		assertEquals("Logged out!\n", msg);
	}*/
	
	@Test
	public void test_UserLogin09() throws Exception {
		UserLogin user = UserLogin.getInstance();
		IUserInfo info = user.getLoggedInUserInfo();
		assertEquals(null, info);
	}
	
	@Test
	public void test_UserLogin10() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("n");
		assertEquals("", msg);
	}
	
	@Test
	public void test_UserLogin11() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0y");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	@Test
	public void test_UserLogin12() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0n");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	@Test
	public void test_UserLogin13() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	@Test
	public void test_UserLogin14() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String name = user.getLoggedinUsername();
		assertEquals("", name);
	}
}
