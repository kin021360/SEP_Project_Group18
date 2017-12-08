package usermanagementsystem.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

import usermanagementsystem.controller.AdminController;
import usermanagementsystem.controller.IController;
import usermanagementsystem.dataaccess.UserDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumGender;
import usermanagementsystem.datastructure.EnumPosition;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.datastructure_interface.ISupervisorInfo;
import usermanagementsystem.exception.ExInvalidChoice;
import usermanagementsystem.user_login.UserLogin;

public class TestController_Leo {

	@Test
	public void testUserGetAllFunctionDesc() {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.getAllFunctionsDesc();
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminGetAllFunctionDesc() {
		UserLogin userLogin = UserLogin.getInstance();
		IController admin = userLogin.login("james", "104");
		String result = admin.getAllFunctionsDesc();
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		funcChoicesDescriptions.add("Create new user.");
		funcChoicesDescriptions.add("Create new supervisor.");
		funcChoicesDescriptions.add("Remove user or supervisor.");
		funcChoicesDescriptions.add("Upgrade existing user to supervisor.");
		funcChoicesDescriptions.add("Add a new permission to user.");
		funcChoicesDescriptions.add("Remove the permission from user.");
		funcChoicesDescriptions.add("Reset user password.");
		funcChoicesDescriptions.add("Print all normal users details.");
		funcChoicesDescriptions.add("Print all supervisors details.");
		funcChoicesDescriptions.add("Print all people details.");
		funcChoicesDescriptions.add("View a user details.");
		funcChoicesDescriptions.add("View all permissions of a user.");
		funcChoicesDescriptions.add("List all available Departments.");
		funcChoicesDescriptions.add("List all available Permissions.");
		funcChoicesDescriptions.add("List all available Positions.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorGetAllFunctionDesc() {
		UserLogin userLogin = UserLogin.getInstance();
		IController supervisor = userLogin.login("efg", "666");
		String result = supervisor.getAllFunctionsDesc();
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		funcChoicesDescriptions.add("Check a user who is my subordinate or not.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserValidateChoiceGetFuncDetail_1() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.validateChoiceGetFuncDetail("0");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserValidateChoiceGetFuncDetail_2() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.validateChoiceGetFuncDetail("1");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserValidateChoiceGetFuncDetail_3() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.validateChoiceGetFuncDetail("2");
		String expect = "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserValidateChoiceGetFuncDetail_4() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.validateChoiceGetFuncDetail("3");
		String expect = "Please enter the document name or enter 'all' to show all documents:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test(expected = ExInvalidChoice.class)
	public void testUserValidateChoiceGetFuncDetail_5() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.validateChoiceGetFuncDetail("4");
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_1() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("4");
		String expect = "Please enter the 'user name', 'password', 'gender', 'position', 'email', 'department', 'isAdmin' to create user:";
		;

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_2() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("5");
		String expect = "Please enter the 'user name', 'password', 'gender', 'position', 'email', 'department', 'isAdmin' to create supervisor:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_3() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("6");
		String expect = "Please enter the user name to remove user or supervisor:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_4() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("7");
		String expect = "Please enter the user name to upgrade user to supervisor:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_5() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("14");
		String expect = "Please enter the user name";
		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_6() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("8");
		String expect = "Please enter the user name and permission to add permission for user:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_7() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("9");
		String expect = "Please enter the user name and permission to remove permission for user:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_8() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("10");
		String expect = "Please enter the user name";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_9() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("11");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_10() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("12");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_11() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("13");
		String expect = "";
		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_12() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("15");
		String expect = "Please enter the user name";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_13() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("16");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_14() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("17");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_15() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("18");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);
	}

	@Test(expected = ExInvalidChoice.class)
	public void testAdminValidateChoiceGetFuncDetail_16() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("19");
	}

	public void testAdminValidateChoiceGetFuncDetail_17() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("0");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_18() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("1");
		String expect = "";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_19() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("2");
		String expect = "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminValidateChoiceGetFuncDetail_20() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("3");
		String expect = "Please enter the document name or enter 'all' to show all documents:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	public void testSupervisorValidateChoiceGetFuncDetail_1() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.validateChoiceGetFuncDetail("0");
		String expect = "";
		assertEquals(expect, result);
	}

	@Test
	public void testSupervisorValidateChoiceGetFuncDetail_2() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.validateChoiceGetFuncDetail("1");
		String expect = "";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorValidateChoiceGetFuncDetail_3() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.validateChoiceGetFuncDetail("2");
		String expect = "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorValidateChoiceGetFuncDetail_4() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.validateChoiceGetFuncDetail("3");
		String expect = "Please enter the document name or enter 'all' to show all documents:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorValidateChoiceGetFuncDetail_5() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.validateChoiceGetFuncDetail("4");
		String expect = "Please enter the user name:";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test(expected = ExInvalidChoice.class)
	public void testSupervisorValidateChoiceGetFuncDetail_6() throws ExInvalidChoice {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.validateChoiceGetFuncDetail("6");
	}

	@Test
	public void testUserChoiceHandler_1() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.choiceHandler("0", null);
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserChoiceHandler_2() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String result = user.choiceHandler("1", null);
		String expect = "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "abc            Male     abc@abc.com             Programmer      Technology           efg";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserChoiceHandler_3() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String[] testInput = { "99", "999", "999" };

		String result = user.choiceHandler("2", testInput);
		String expect = "Password changed!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserChoiceHandler_4() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "999");
		String[] testInput = { "99", "999", "999" };
		String result = user.choiceHandler("2", testInput);
		String expect = "Old password is incorrect!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserChoiceHandler_5() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "999");
		String[] testInput = { "999", "99", "999" };
		String result = user.choiceHandler("2", testInput);
		String expect = "New password and confirm new password are different!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testUserChoiceHandler_6() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "999");
		String[] testInput = {};
		String result = user.choiceHandler("3", testInput);
		String expect = "\n" + "The following documents are belonging to your department.\n"
				+ "Document content --- 'qqq':\n" + "gsrhshhhhhrrrrgedgahha\n" + "\n" + "Document content --- 'ppp':\n"
				+ "fsegaeahaehaehxxx564\n" + "\n" + "";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test(expected = Exception.class)
	public void testUserChoiceHandler_7() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "999");
		String result = user.choiceHandler("5", null);
	}

	@Test
	public void testUserChoiceHandler_8() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "999");
		String[] testInput = { "99" };
		String result = user.choiceHandler("3", testInput);
		String expect = "Document '99' not found in your department!";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorChoiceHandler_1() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String result = user.choiceHandler("0", null);
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		funcChoicesDescriptions.add("Check a user who is my subordinate or not.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorChoiceHandler_2() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String[] testInput = { "abc" };
		String result = user.choiceHandler("4", testInput);
		String expect = testInput[0] + " is your subordinate.";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testSupervisorChoiceHandler_3() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("efg", "666");
		String[] testInput = { "99" };
		String result = user.choiceHandler("4", testInput);
		String expect = testInput[0] + " is not your subordinate.";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_1() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.choiceHandler("0", null);
		String expect = "";
		ArrayList<String> funcChoicesDescriptions = new ArrayList<>();
		funcChoicesDescriptions.add("Print all supported operations.");
		funcChoicesDescriptions.add("Print my details.");
		funcChoicesDescriptions.add("Change my password.");
		funcChoicesDescriptions.add("View my department document.");
		funcChoicesDescriptions.add("Create new user.");
		funcChoicesDescriptions.add("Create new supervisor.");
		funcChoicesDescriptions.add("Remove user or supervisor.");
		funcChoicesDescriptions.add("Upgrade existing user to supervisor.");
		funcChoicesDescriptions.add("Add a new permission to user.");
		funcChoicesDescriptions.add("Remove the permission from user.");
		funcChoicesDescriptions.add("Reset user password.");
		funcChoicesDescriptions.add("Print all normal users details.");
		funcChoicesDescriptions.add("Print all supervisors details.");
		funcChoicesDescriptions.add("Print all people details.");
		funcChoicesDescriptions.add("View a user details.");
		funcChoicesDescriptions.add("View all permissions of a user.");
		funcChoicesDescriptions.add("List all available Departments.");
		funcChoicesDescriptions.add("List all available Permissions.");
		funcChoicesDescriptions.add("List all available Positions.");
		for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
			expect += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		}

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_2() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String result = user.choiceHandler("1", null);
		String expect = "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "james          Male     james@james.com         Programmer      Technology           null";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_3() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String[] testInput = { "104", "104", "104" };

		String result = user.choiceHandler("2", testInput);
		String expect = "Password changed!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_4() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String[] testInput = { "99", "999", "999" };
		String result = user.choiceHandler("2", testInput);
		String expect = "Old password is incorrect!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_5() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String[] testInput = { "104", "99", "999" };
		String result = user.choiceHandler("2", testInput);
		String expect = "New password and confirm new password are different!";

		// "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
		assertEquals(expect, result);

		// String userName, String password, EnumGender gender, EnumPosition position,
		// long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo
		// supervisor, boolean isAdmin
	}

	@Test
	public void testAdminChoiceHandler_6() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		String[] testInput = {};
		String result = user.choiceHandler("3", testInput);
		String expect = "\n" + "The following documents are belonging to your department.\n"
				+ "Document content --- 'qqq':\n" + "gsrhshhhhhrrrrgedgahha\n" + "\n" + "Document content --- 'ppp':\n"
				+ "fsegaeahaehaehxxx564\n" + "\n";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_7() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("4", testInput);
		String expect = "Create User successfully!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_8() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "abc", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("4", testInput);
		String expect = "User is already existed!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_9() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { null, "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("4", testInput);
		String expect = "User is already existed!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_10() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "efg", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("5", testInput);
		String expect = "Supervisor is already existed!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_11() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { null, "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("5", testInput);
		String expect = "Supervisor is already existed!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_12() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "def", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("5", testInput);
		String expect = "Create Supervisor successfully!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_13() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "def", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("6", testInput);
		String expect = "Remove User successfully!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_14() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "cde", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("6", testInput);
		String expect = "User not found!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_15() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("6", testInput);
		String expect = "Remove User successfully!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_16() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { null };
		String result = user.choiceHandler("6", testInput);
		String expect = "User not found!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_17() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "cde", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("4", testInput);

		result = user.choiceHandler("7", testInput[0]);
		String expect = "Upgrade User to Supervisor successfully!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_18() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "ddd" };
		String result = user.choiceHandler("7", testInput);
		String expect = "User not found!";
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_19() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "abc", "ListUsers" };
		String result = user.choiceHandler("8", testInput);
		String expect = "Permission added!";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_20() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "ddd", "ListUsers" };
		String result = user.choiceHandler("8", testInput);
		String expect = "User not found!";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_21() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "abc", "ViewDocument" };
		String result = user.choiceHandler("9", testInput);
		String expect = "Permission removed!";
		assertNotNull(result);
		assertEquals(expect, result);
		result = user.choiceHandler("8", testInput);

	}

	@Test
	public void testAdminChoiceHandler_22() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "ddd", "ListUsers" };
		String result = user.choiceHandler("9", testInput);
		String expect = "User not found!";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_23() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo", "123", "Male", "Programmer", "testing@mail.com", "Technology", "false" };
		String result = user.choiceHandler("4", testInput);
		result = user.choiceHandler("10", testInput[0]);
		IController testUser = userLogin.login("Leo", "123456");
		boolean isReset = false;
		if (testUser != null) {
			isReset = true;
		};
		String expect = testInput[0]
				+ "'s password have reset to '123456'. Please notify the user to change their password.";
		assertTrue(isReset);
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_24() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("11", testInput);
		String expect = "All users details:\n"
				+ "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "Woman          Female   Woman@mail.com          Saler           HumanResource        null\n"
				+ "abc            Male     abc@abc.com             Programmer      Technology           efg\n"
				+ "Leo            Male     testing@mail.com        Programmer      Technology           null\n"
				+ "james          Male     james@james.com         Programmer      Technology           null\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_25() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("12", testInput);
		String expect = "All supervisors details:\n"
				+ "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "efg            Male     efg@efg.com             Programmer      Technology           null\n"
				+ "cde            Male     testing@mail.com        Programmer      Technology           null\n";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_26() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("13", testInput);
		String expect = "All users details:\n"
				+ "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "Woman          Female   Woman@mail.com          Saler           HumanResource        null\n"
				+ "abc            Male     abc@abc.com             Programmer      Technology           efg\n"
				+ "Leo            Male     testing@mail.com        Programmer      Technology           null\n"
				+ "james          Male     james@james.com         Programmer      Technology           null\n" + "\n"
				+ "All supervisors details:\n"
				+ "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "efg            Male     efg@efg.com             Programmer      Technology           null\n"
				+ "cde            Male     testing@mail.com        Programmer      Technology           null\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_27() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo" };
		String result = user.choiceHandler("14", testInput);
		String expect = "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "Leo            Male     testing@mail.com        Programmer      Technology           null";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_28() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "ddd" };
		String result = user.choiceHandler("14", testInput);
		String expect = "User not found!";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_29() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo" };
		String result = user.choiceHandler("14", testInput);
		String expect = "User Name      Gender   Email                   Position        My Department        My Supervisor\n"
				+ "Leo            Male     testing@mail.com        Programmer      Technology           null";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_30() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "Leo" };
		String result = user.choiceHandler("15", testInput);
		String expect = "Current Permission: \n" + "Name of Permission       Id\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_31() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { "ddd" };
		String result = user.choiceHandler("15", testInput);
		String expect = "User not found!";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_32() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("16", testInput);
		String expect = "Name of Department       Id\n" + "        Technology  ---   0\n"
				+ "     HumanResource  ---   1\n" + "           Finance  ---   2\n" + "         Marketing  ---   3\n"
				+ "             Sales  ---   4\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_33() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("17", testInput);
		String expect = "Name of Permission       Id\n" + "      ViewDocument  ---   0\n"
				+ "         ListUsers  ---   1\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_34() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = {};
		String result = user.choiceHandler("18", testInput);
		String expect = "Name of Position       Id\n" + "      Programmer  ---   0\n" + "           Saler  ---   1\n"
				+ "        Engineer  ---   2\n" + "QualityAssurance  ---   3\n" + "    ProductOwner  ---   4\n" + "";
		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testAdminChoiceHandler_35() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] testInput = { null };
		String result = user.choiceHandler("10", testInput);
		String expect = "User not found!";

		assertNotNull(result);
		assertEquals(expect, result);
	}

	@Test
	public void testUserGetDepartmentDocr_1() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] createInput = { "Woman", "103", "Female", "Saler", "Woman@mail.com", "HumanResource", "false" };
		String result = user.choiceHandler("4", createInput);

		user = userLogin.login("Woman", "103");
		String[] testInput = { "document" };
		result = user.choiceHandler("3", testInput);
		String expect = "You do not have ViewDocument permission";
		assertEquals(expect, result);

	}

	@Test
	public void testUserGetDepartmentDocr_2() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("james", "104");
		// String userName, String password, String gender, String position, String
		// email, String departmentOf, String isAdmin
		String[] permissionInput = { "Woman", "ViewDocument" };
		String result = user.choiceHandler("8", permissionInput);
		user = userLogin.login("Woman", "103");
		String[] testInput = { "document" };
		result = user.choiceHandler("3", testInput);
		String expect = "Your department does not have any document!";
		assertEquals(expect, result);

	}

	@Test
	public void testUserGetDepartmentDocr_3() throws Exception {
		UserLogin userLogin = UserLogin.getInstance();
		IController user = userLogin.login("abc", "99");
		String[] testInput = { "qqq" };
		String result = user.choiceHandler("3", testInput);
		String expect = "Document content --- 'qqq':\n" + "gsrhshhhhhrrrrgedgahha\n" + "\n" + "";
		assertEquals(expect, result);

	}
}
