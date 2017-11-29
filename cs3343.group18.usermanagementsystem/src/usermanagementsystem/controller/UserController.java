package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

import java.util.ArrayList;

/**
 * Created by Nathan Lam on 11/11/2017.
 */
public class UserController implements IController {
    protected User currentUser;
    private ViewDocController viewDocController;
    private static UserController instance = new UserController();
    protected ArrayList<String> funcChoicesDescriptions;

    protected UserController() {
        currentUser = null;
        viewDocController = ViewDocController.getInstance();
        funcChoicesDescriptions = new ArrayList<>();
        funcChoicesDescriptions.add("Print all supported operations.");
        funcChoicesDescriptions.add("Print my details.");
        funcChoicesDescriptions.add("Change my password.");
        funcChoicesDescriptions.add("View my department document.");
    }

    public static UserController getInstance(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        return instance;
    }

    private String getMyDetails() {
        return "User Name      Gender   Email                   Position        My Department        My Supervisor\n" + currentUser.toString();
    }

//    public String canIDo(EnumPermission permission) {
//        if (currentUser.hasPermission(permission)){
//            return "Yes, you can!";
//        }
//        return "No, you don't have this permission";
//    }

    private String changeMyPassword(String oldPassword, String newPassword, String confirmNewPassword) {
        if (currentUser.checkPassword(oldPassword)) {
            if (newPassword.equals(confirmNewPassword)) {
                currentUser.changePassword(newPassword);
                return "Password changed!";
            }
            return "New password and confirm new password are different!";
        }
        return "Old password is incorrect!";
    }

    public String getDepartmentDoc(String optionalDocName) {
        return viewDocController.getDepartmentDoc(currentUser, optionalDocName);
    }

    @Override
    public String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice {
        switch (choice) {
//            case "0":
//                return "";
            case "1":
                return "";
            case "2":
                return "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";
            case "3":
                return "Please enter the document name or enter 'all' to show all documents:";
        }
        throw new ExInvalidChoice();
    }

    @Override
    public String choiceHandler(String choice, String... values) throws Exception {
        switch (choice) {
//            case "0":
//                return getAllFunctionsDesc();
            case "1":
                return getMyDetails();
            case "2":
                return changeMyPassword(values[0], values[1], values[2]);
            case "3":
                return viewDocController.getDepartmentDoc(currentUser, values.length == 0 ? null : values[0]);
        }
        throw new ExInvalidChoice();
    }

    @Override
    public String getAllFunctionsDesc() {
        String temp = "";
        for (int i = 1; i < funcChoicesDescriptions.size(); i++) {
            temp += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
        }
        return temp;
    }

    public void clear() {
        currentUser = null;
    }
}
