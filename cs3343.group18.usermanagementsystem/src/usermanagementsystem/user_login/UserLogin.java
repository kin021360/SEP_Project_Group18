package usermanagementsystem.user_login;

import usermanagementsystem.dataaccess.*;

public class UserLogin {
	private boolean loggedin;	
	private UserDao userDao;
	//only keep username as login user will not enter username again
	//and it is key for select info from hash table
	private String username;
	
	private static UserLogin instance = new UserLogin();
	
	private UserLogin() {
		this.loggedin = false;		
		//load users based on data.json
		this.userDao = new UserDao();
	}
	
	public static UserLogin getInstance () {
		return instance;
	}

	public boolean getLoginStatus() {
		return loggedin;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loggedin = loginStatus;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String logoutProcess(String choice) {
		switch(choice){
  	   	case "y":
  	   		setLoginStatus(false);
  	   		return "Logged out!\n";
  	   	case "n":
  	   		return "";
  	   	default:
  	   		return "Please enter \"Y\" or \"N\"!\n";
  	   	}
	}
}
