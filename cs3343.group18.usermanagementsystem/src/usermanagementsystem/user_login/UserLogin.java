package usermanagementsystem.user_login;

import usermanagementsystem.controller.AdminController;
import usermanagementsystem.controller.IController;
import usermanagementsystem.controller.SupervisorController;
import usermanagementsystem.controller.UserController;
import usermanagementsystem.dataaccess.UserDao;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.exception.ExControllerInitWithNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

public class UserLogin {
	private Hashtable<String, User> users;
	private Hashtable<String, Supervisor> supervisors;
	private boolean isLoggedIn;
	private UserDao userDao;
	private User loggedInUser;
	private IController controller;

	private static UserLogin instance = new UserLogin();

	private UserLogin() {
		this.isLoggedIn = false;
		this.loggedInUser = null;
		this.controller = null;
		// load users based on data.json
		this.userDao = new UserDao();
		// load User and Supervisor list(Hashtable) without mapping their Supervisor or
		// Subordinate yet
		this.users = userDao.loadUsersWithoutSupervisor();
		this.supervisors = userDao.loadSupervisorsWithoutUser();
		// Map User's Supervisor and Supervisor's Subordinate
		this.userDao.mapUserSupervisor(users, supervisors);
	}

	public static UserLogin getInstance() {
		return instance;
	}

	private User getUserOrSupervisor(String userName) {
		if (userName == null)
			return null;
		if (users.containsKey(userName)) {
			return users.get(userName);
		} else if (supervisors.containsKey(userName)) {
			return supervisors.get(userName);
		}
		return null;
	}

	public boolean getLoginStatus() {
		return isLoggedIn;
	}

	private void clearLoginStatus() {
		this.isLoggedIn = false;
		this.loggedInUser = null;
		this.controller.clear();
		this.controller = null;
	}

	public String getLoggedInUsername() {
		if (isLoggedIn) {
			return loggedInUser.getUserName();
		}
		return "";
	}

	public void logoutProcess() {
		clearLoginStatus();
		updateAndSave();
	}

	public IController login(String username, String password) {
		User tempUser = getUserOrSupervisor(username);
		if (tempUser != null && tempUser.getSuspensionTimeStamp() != 0
				&& tempUser.getSuspensionTimeStamp() < (System.currentTimeMillis() / 1000)) {
			tempUser.setLoginFailTime(0);
			tempUser.setSuspensionTimeStamp(0);
		}
		if (tempUser != null && tempUser.checkPassword(password) && tempUser.getLoginFailTime() < 3) {
			loggedInUser = tempUser;
			isLoggedIn = true;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    		Date currDate = new Date();
	    		String currDateFormat = sdf.format(currDate);
	    		String[] currDateArr = currDateFormat.split("-");
	    		if(currDateArr[0].equals("01") && currDateArr[1].equals("01")) {
	    			tempUser.setAnnualLeave(12);
	    		}
	    		
				if (tempUser.isAdmin()) {
					controller = AdminController.getInstance(loggedInUser, users, supervisors);
				} else if (tempUser.isSupervisor()) {
					controller = SupervisorController.getInstance(loggedInUser, users);
				} else {
					controller = UserController.getInstance(loggedInUser);
				}
				tempUser.setLoginFailTime(0);
				return controller;
			} catch (ExControllerInitWithNull e) {
				return null;
			}
		} else if (tempUser != null && !tempUser.checkPassword(password)) {
			tempUser.setLoginFailTime(tempUser.getLoginFailTime() + 1);
			if (tempUser.getLoginFailTime() == 3) {
				tempUser.setSuspensionTimeStamp(System.currentTimeMillis() / 1000 + 60);
				updateAndSave();
			}
		}
		if (tempUser != null && tempUser.getLoginFailTime() >= 3) {
			System.out.println("Your account is suspended for one minute!");
		}
		return null;
	}

	private void updateAndSave() {
		userDao.updateAndSave(users, supervisors);
	}
}
