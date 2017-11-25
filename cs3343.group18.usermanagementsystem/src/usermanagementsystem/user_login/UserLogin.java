package usermanagementsystem.user_login;

import usermanagementsystem.controller.AdminController;
import usermanagementsystem.controller.IController;
import usermanagementsystem.controller.SupervisorController;
import usermanagementsystem.controller.UserController;
import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.datastructure_interface.IUserInfo;
import usermanagementsystem.exception.ExControllerInitWithNull;

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
        // load users based on data.json
        this.userDao = new UserDao();
        // load User and Supervisor list(Hashtable) without mapping their Supervisor or Subordinate yet
        this.users = userDao.loadUsersWithoutSupervisor();
        this.supervisors = userDao.loadSupervisorsWithoutUser();
        // Map User's Supervisor and Supervisor's Subordinate
        this.userDao.mapUserSupervisor(users, supervisors);
    }

    public static UserLogin getInstance() {
        return instance;
    }

    private User getUserOrSupervisor(String userName) {
        if (userName == null) return null;
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
    }

    public String getLoggedinUsername() {
        if (isLoggedIn) {
            return loggedInUser.getUserName();
        }
        return "";
    }

    public String logoutProcess(String choice) {
        switch (choice) {
            case "y":
                clearLoginStatus();
                updateAndSave();
                controller.clear();
                controller = null;
                return "Logged out!\n";
            case "n":
                return "";
            default:
                return "Please enter \"Y\" or \"N\"!\n";
        }
    }

    public IController login(String username, String password) {
        User tempUser = getUserOrSupervisor(username);
        if (tempUser != null && tempUser.checkPassword(password)) {
            loggedInUser = tempUser;
            isLoggedIn = true;
            try {
                if (tempUser.isAdmin()) {
                    return AdminController.getInstance(loggedInUser, users, supervisors);
                } else if (tempUser.isSupervisor()) {
                    return SupervisorController.getInstance(loggedInUser);
                }
                return UserController.getInstance(loggedInUser);
            } catch (ExControllerInitWithNull e) {
                return null;
            }
        }
        return null;
    }

    public IUserInfo getLoggedInUserInfo() {
        return loggedInUser;
    }

    private void updateAndSave() {
        userDao.updateAndSave(users, supervisors);
    }

    public boolean checkUserExist(String username) {
        User tempUser = getUserOrSupervisor(username);
        return tempUser != null;
    }
}
