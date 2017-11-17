package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;

/**
 * Created by Nathan Lam on 11/11/2017.
 */
public class UserController {
    protected User currentUser;

    public UserController(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        currentUser = user;
    }

    public String getMyDetails() {
        return currentUser.toString();
    }

    public boolean canIDo(EnumPermission permission) {
        return currentUser.hasPermission(permission);
    }

    public boolean changeMyPassword(String oldPassword, String newPassword) {
        if (currentUser.checkPassword(oldPassword)) {
            currentUser.changePassword(newPassword);
            return true;
        }
        return false;
    }
}
