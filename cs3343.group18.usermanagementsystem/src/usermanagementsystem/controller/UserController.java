package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

import java.util.ArrayList;

/**
 * The base Controller class for normal user.
 */
public class UserController implements IController {
    protected User currentUser;
    private ViewDocController viewDocController;
    private static UserController instance = new UserController();
    protected ArrayList<String> funcChoicesDescriptions;

    /**
     * The constructor init the ViewDocController ref and choices description list.
     */
    protected UserController() {
        currentUser = null;
        viewDocController = ViewDocController.getInstance();
        funcChoicesDescriptions = new ArrayList<>();
        ControllerHelper.initUserChoicesDescriptions(funcChoicesDescriptions);
    }

    /**
     * Singleton UserController
     *
     * @param user User
     * @return instance UserController
     * @throws ExControllerInitWithNull the input param cannot be null
     */
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

    /**
     * Change current user's password
     *
     * @param oldPassword        old password
     * @param newPassword        new password
     * @param confirmNewPassword re-enter password
     * @return change password result message
     */
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

    /**
     * @param optionalDocName (with value 'all' the get all document
     * @return document content
     */
    public String getDepartmentDoc(String optionalDocName) {
        return viewDocController.getDepartmentDoc(currentUser, optionalDocName);
    }

    /**
     * Validate the choice and get choice detail
     *
     * @param choice string number, 0 based
     * @return string description for the choice, can be empty string
     * @throws ExInvalidChoice no existing choice in controller
     */
    @Override
    public String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice {
        switch (choice) {
            case "0":
                return "";
            case "1":
                return "";
            case "2":
                return "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";
            case "3":
                return "Please enter the document name or enter 'all' to show all documents:";
        }
        throw new ExInvalidChoice();
    }

    /**
     * Involve the action based on the choice
     *
     * @param choice string number, 0 based
     * @param values for the choice, in string array / string array param
     * @return string message
     * @throws Exception include the message that the action cannot be executed
     */
    @Override
    public String choiceHandler(String choice, String... values) throws Exception {
        switch (choice) {
            case "0":
                return getAllFunctionsDesc();
            case "1":
                return getMyDetails();
            case "2":
                return changeMyPassword(values[0], values[1], values[2]);
            case "3":
                return viewDocController.getDepartmentDoc(currentUser, values.length == 0 ? null : values[0]);
        }
        throw new ExInvalidChoice();
    }

    /**
     * @return all supported choices function description
     */
    @Override
    public String getAllFunctionsDesc() {
        String temp = "";
        for (int i = 0; i < funcChoicesDescriptions.size(); i++) {
            temp += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
        }
        return temp;
    }

    /**
     * Clear current user session in controller
     */
    public void clear() {
        currentUser = null;
    }
}
