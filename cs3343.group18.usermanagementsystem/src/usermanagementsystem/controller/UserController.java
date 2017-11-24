package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;

/**
 * Created by Nathan Lam on 11/11/2017.
 */
public class UserController {
    protected User currentUser;
    private ViewDocController viewDocController;

    public UserController(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        currentUser = user;
        viewDocController = ViewDocController.getInstance();
    }

    public String getMyDetails() {
        return currentUser.toString();
    }

    public boolean canIDo(EnumPermission permission) {
        return currentUser.hasPermission(permission);
    }

    //comment for modify this function below
//    public boolean changeMyPassword(String oldPassword, String newPassword) {
//        if (currentUser.checkPassword(oldPassword)) {
//            currentUser.changePassword(newPassword);
//            return true;
//        }
//        return false;
//    }

    public String getDepartmentDoc(String optionalDocName) {
        return viewDocController.getDepartmentDoc(currentUser, optionalDocName);
    }

    public void destroy() {
        currentUser = null;
    }
    
    
    //move user function from UserInfo to UserController
    public String changeMyPassword(String oldPassword, String newPassword, String confirmNewPassword) {
		if (currentUser.checkPassword(oldPassword)) {
			if (newPassword.equals(confirmNewPassword)) {
				currentUser.changePassword(newPassword);
				return "Password changed!";
			} else {
				return "New password and confirm new password are different!";
			}
		} else {
			return "Old password is invalid!";
		}
	}
    //move user function from UserInfo to UserController
}
