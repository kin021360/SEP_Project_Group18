package usermanagementsystem.user_info;

import usermanagementsystem.datastructure.User;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.datastructure.EnumPermission;

public class UserInfo {
//	public static void changePw(User loggedInUser, boolean samePw, String newPw, String confirmNewPw) {
//		if (samePw) {
//			if (newPw.equals(confirmNewPw)) {
//				loggedInUser.changePassword(newPw);
//				System.out.println("Password changed!");
//			} else {
//				System.out.println("New password and confirm new password are different!");
//			}
//		} else {
//			System.out.println("Old password is invalid!");
//		}
//	}
//
//	public static void changePw(User user, String newPw, String confirmNewPw) {
//		if (newPw.equals(confirmNewPw)) {
//			user.changePassword(newPw);
//			System.out.println("Password changed!");
//		} else {
//			System.out.println("New password and confirm new password are different!");
//		}
//	}
//
//	public static void getUserInfo(User user) {
//		String[] userInfoArr = null;
//		if (user != null) {
//			userInfoArr = user.toString().split("-");
//		} else {
//			System.out.println("User does not exist!");
//		}
//		if (userInfoArr != null) {
//			System.out.println("Username: " + userInfoArr[0]);
//			System.out.println("Password: " + userInfoArr[3]);
//			System.out.println("Sex: " + userInfoArr[1]);
//			System.out.println("Email: " + userInfoArr[4]);
//			System.out.println("Position: " + userInfoArr[2]);
//
//			String[] departmentSupervisor = userInfoArr[5].split(", Supervisor = ");
//			System.out.println("Department: " + departmentSupervisor[0]);
//			System.out.println("Supervisor: " + departmentSupervisor[1]);
//		}
//	}
//
//	public static void listCurrentUserPermission(User user) {
//		String[] userPermissionArr = null;
//		if (user != null) {
//			userPermissionArr = user.showAllPermissions().split(",");
//		} else {
//			System.out.println("User does not exist!");
//		}
//		if (userPermissionArr != null) {
//			int permissionId = 0;
//			System.out.println("Current Permission: ");
//			String temp = "Name of Permission       Id\n";
//			for (String e : userPermissionArr) {
//				temp += String.format("%18s  ---  %2d\n", e, permissionId);
//				permissionId++;
//			}
//			System.out.println(temp);
//		}
//	}
//
//	public static void editUserPermission(int option) {
//		if (option == 1) {
//			System.out.println("Available Permission: ");
//			System.out.println(EnumPermission.listAll());
//		} else if (option == 0) {
//			System.out.println("Back to main menu!");
//		} else {
//			System.out.println("Invalid option!");
//		}
//	}
//
//	public static void addUserPermission(User user, int permissionId) throws ExInvaildEnumValue {
//		EnumPermission enumPermission = EnumPermission.parse(permissionId);
//		if (!user.hasPermission(enumPermission)) {
//			user.addPermission(enumPermission);
//			System.out.println("Permission granted!");
//		} else {
//			System.out.println("Permission granted before!");
//		}
//	}
//
//	public static void removeUserPermission(User user, int permissionId) throws ExInvaildEnumValue {
//		EnumPermission enumPermission = EnumPermission.parse(permissionId);
//		if (user.hasPermission(enumPermission)) {
//			user.removePermission(enumPermission);
//			System.out.println("Permission removed!");
//		} else {
//			System.out.println("User do not have this permission!");
//		}
//	}
}
