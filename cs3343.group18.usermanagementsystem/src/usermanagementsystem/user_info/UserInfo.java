package usermanagementsystem.user_info;

import usermanagementsystem.datastructure.User;
import usermanagementsystem.datastructure.Supervisor;

public class UserInfo {
	public static void changePw(User loggedInUser, boolean samePw, String newPw, String confirmNewPw) {
		if(samePw) {
			if(newPw.equals(confirmNewPw)) {
				loggedInUser.changePassword(newPw);
				System.out.println("Password changed!");
			}else {
				System.out.println("New password and confirm new password are different!");				
			}
		}else {
			System.out.println("Old password is invalid!");
		}
	}
	
	public static void changePw(User user, String newPw, String confirmNewPw) {
		if(newPw.equals(confirmNewPw)) {
			user.changePassword(newPw);
			System.out.println("Password changed!");
		}else {
			System.out.println("New password and confirm new password are different!");
		}
	}
	
	public static void getUserInfo(User user, Supervisor supervisor) {
		String[] userInfoArr;
        if (user != null) {
        	userInfoArr = user.toString().split("-");
        	System.out.println("Username: " + userInfoArr[0]);
        	System.out.println("Password: " + userInfoArr[3]);
        	System.out.println("Sex: " + userInfoArr[1]);
        	System.out.println("Email: " + userInfoArr[4]);
        	System.out.println("Position: " + userInfoArr[2]);
        	
        	String[] departmentSupervisor = userInfoArr[5].split(", Supervisor = ");
        	System.out.println("Department: " + departmentSupervisor[0]);
        	System.out.println("Supervisor: " + departmentSupervisor[1]);
        } else if (supervisor != null) {
        	userInfoArr = supervisor.toString().split("-");
        	System.out.println("Username: " + userInfoArr[0]);
        	System.out.println("Password: " + userInfoArr[3]);
        	System.out.println("Sex: " + userInfoArr[1]);
        	System.out.println("Email: " + userInfoArr[4]);
        	System.out.println("Position: " + userInfoArr[2]);
        	
        	String[] departmentSupervisor = userInfoArr[5].split(", Supervisor = ");
        	System.out.println("Department: " + departmentSupervisor[0]);
        	System.out.println("Supervisor: " + departmentSupervisor[1]);        	
        } else {
        	System.out.println("User does not exist!");
        }
	}
	
	public static void userPermission (User user, Supervisor supervisor) {
		String[] userPermissionArr;
		if (user != null) {
			userPermissionArr = user.showAllPermissions().split(",");
			for(String e:userPermissionArr) {
				System.out.println(e);
			}
			
		} else if (supervisor != null) {
			userPermissionArr = supervisor.showAllPermissions().split(",");
			for(String e:userPermissionArr) {
				System.out.println(e);
			}
			
		} else {
        	System.out.println("User does not exist!");
        }
	}
	
}
