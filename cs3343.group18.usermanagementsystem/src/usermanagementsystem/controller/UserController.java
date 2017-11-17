package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;

/**
 * Created by Nathan Lam on 11/11/2017.
 */
public class UserController {
    protected User currentUser;

    public UserController(User user) {
        if (user == null) throw new RuntimeException("Input user cannot be null!");
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
