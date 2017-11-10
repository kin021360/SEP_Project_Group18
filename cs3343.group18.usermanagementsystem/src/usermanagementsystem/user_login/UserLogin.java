package usermanagementsystem.user_login;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.Supervisor;
import usermanagementsystem.datastructure.User;
import usermanagementsystem.datastructure_interface.IUserInfo;

import java.util.Hashtable;

public class UserLogin {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;
    private boolean isLoggedIn;
    private UserDao userDao;
    private User loggedInUser;

    private static UserLogin instance = new UserLogin();

    private UserLogin() {
        this.isLoggedIn = false;
        this.loggedInUser = null;
        //load users based on data.json
        this.userDao = new UserDao();
        //load User and Supervisor list(Hashtable) without mapping their Supervisor or Subordinate yet
        this.users = userDao.loadUsersWithoutSupervisor();
        this.supervisors = userDao.loadSupervisorsWithoutUser();
        //Map User's Supervisor and Supervisor's Subordinate
        this.userDao.mapUserSupervisor(users, supervisors);
    }

    public static UserLogin getInstance() {
        return instance;
    }

    public boolean getLoginStatus() {
        return isLoggedIn;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.isLoggedIn = loginStatus;
        this.loggedInUser = null;
    }

    public String getLoggedinUsername() {
        if(isLoggedIn) {
            return loggedInUser.getUserName();
        }
        return "";
    }

    public String logoutProcess(String choice) {
        switch (choice) {
            case "y":
                setLoginStatus(false);
                return "Logged out!\n";
            case "n":
                return "";
            default:
                return "Please enter \"Y\" or \"N\"!\n";
        }
    }

    public boolean login(String username, String password) {
        User tempUser = users.get(username);
        Supervisor tempSupervisor = supervisors.get(username);
        if (tempUser != null && tempUser.checkPassword(password)) {
            loggedInUser = tempUser;
            isLoggedIn = true;
            return true;
        } else if (tempSupervisor != null && tempSupervisor.checkPassword(password)) {
            loggedInUser = tempSupervisor;
            isLoggedIn = true;
            return true;
        }
        return false;
    }

    public IUserInfo getLoggedInUserInfo() {
        return loggedInUser;
    }
}
