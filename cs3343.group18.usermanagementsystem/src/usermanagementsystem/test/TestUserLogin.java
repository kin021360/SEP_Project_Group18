package usermanagementsystem.test;

import static org.junit.Assert.*;

import org.junit.Test;

import usermanagementsystem.user_login.*;
import usermanagementsystem.controller.AdminController;

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
		boolean login = user.login("abc", "999");
		assertEquals(, login);
	}
	
	@Test
	public void test_UserLogin03() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean login = user.login("efg", "777");
		assertEquals(true, login);
	}
	
	@Test
	public void test_UserLogin04() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean login = user.login("efg", "");
		assertEquals(false, login);
	}
	
	@Test
	public void test_UserLogin05() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean login = user.login("abc", "");
		assertEquals(false, login);
	}
	
	@Test
	public void test_UserLogin06() throws Exception {
		UserLogin user = UserLogin.getInstance();
		boolean login = user.login("abc", "999");
		String name = user.getLoggedinUsername();
		assertEquals("abc", name);
	}
	
	@Test
	public void test_UserLogin07() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("y");
		assertEquals("Logged out!\n", msg);
	}
	
	@Test
	public void test_UserLogin08() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String name = user.getLoggedinUsername();
		assertEquals("", name);
	}
	
	@Test
	public void test_UserLogin09() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("n");
		assertEquals("", msg);
	}
	
	@Test
	public void test_UserLogin10() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0y");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	@Test
	public void test_UserLogin11() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0n");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	@Test
	public void test_UserLogin12() throws Exception {
		UserLogin user = UserLogin.getInstance();
		String msg = user.logoutProcess("\0");
		assertEquals("Please enter \"Y\" or \"N\"!\n", msg);
	}
	
	
}
