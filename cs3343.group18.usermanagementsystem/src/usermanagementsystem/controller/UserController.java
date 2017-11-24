package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

import java.util.ArrayList;

/**
 * Created by Nathan Lam on 11/11/2017.
 */
public class UserController {
    protected User currentUser;
    private ViewDocController viewDocController;
    private static UserController instance = new UserController();
    protected ArrayList<String> funcChoicesDescriptions;

    public UserController() {
        currentUser = null;
        viewDocController = ViewDocController.getInstance();
        funcChoicesDescriptions = new ArrayList<>();
        funcChoicesDescriptions.add("uuuuuuu");
    }

    public static UserController getInstance(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        return instance;
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

    public String getDepartmentDoc(String optionalDocName) {
        return viewDocController.getDepartmentDoc(currentUser, optionalDocName);
    }

    public String validateChoiceGetFuncDetail(int choice) throws ExInvalidChoice {
        if (choice > 0 && choice <= funcChoicesDescriptions.size()) {
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
            }
        }
        return "";
    }

    public String choiceHandler(int choice, String[] values) throws Exception {
        switch (choice) {
            case 0:
                return getAllFunctionsDesc();
            case 1:
                break;
            case 2:
                break;
        }
        throw new ExInvalidChoice();
    }

    public String getAllFunctionsDesc() {
        String temp = "\t 0 --- Print All Functions\n";
        for (int i = 1; i <= funcChoicesDescriptions.size(); i++) {
            temp += "\t " + i + " --- " + funcChoicesDescriptions.get(i - 1) + "\n";
        }
        return temp;
    }

    public void clear() {
        currentUser = null;
    }
}
