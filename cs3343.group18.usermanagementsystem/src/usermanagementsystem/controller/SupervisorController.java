package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

import java.util.Hashtable;

/**
 * The Controller class for Supervisor.
 */
public class SupervisorController extends UserController {
    private static SupervisorController instance = new SupervisorController();
    private Hashtable<String, User> users;
    private int numOfBaseFunc;

    /**
     * The constructor init the ViewDocController ref and choices description list.
     */
    private SupervisorController() {
        super();
        numOfBaseFunc = funcChoicesDescriptions.size();
        ControllerHelper.initSupervisorChoicesDescriptions(funcChoicesDescriptions);
    }

    /**
     * Singleton SupervisorController
     *
     * @param user User
     * @return instance SupervisorController
     * @throws ExControllerInitWithNull the input param cannot be null
     */
    public static SupervisorController getInstance(User user, Hashtable<String, User> users) throws ExControllerInitWithNull {
        if (user == null || users == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        instance.users = users;
        return instance;
    }

    /**
     * Check the user name which is current supervisor's subordinate or not
     *
     * @param userName user name
     * @return result message
     */
    private String isMySubordinate(String userName) {
        if (((Supervisor) currentUser).isMySubordinate(userName)) {
            return userName + " is your subordinate.";
        }
        return userName + " is not your subordinate.";
    }

    private String getMySubordinatesDetails() {
        String details = ((Supervisor) currentUser).getMySubordinatesDetails();
        if (!details.equals("")) {
            return "All subordinate details:\n" + ControllerHelper.userDetailsHeader + "\n" + details;
        }
        return "You do not have any subordinate";
    }

    /**
     * Add subordinate by name
     *
     * @param subordinateName subordinate name
     */
    private String addSubordinate(String subordinateName) {
        User userToAdd = users.get(subordinateName);
        if (userToAdd != null) {
            if (((Supervisor) currentUser).addSubordinate(userToAdd)) {
                userToAdd.unassignSupervisor();
                userToAdd.assignSupervisor((Supervisor) currentUser);
                return "Add subordinate successfully!";
            }
            return "Subordinate already existed!";
        }
        return "User not found!";
    }

    /**
     * Remove subordinate by name
     *
     * @param subordinateName subordinate name
     * @return result message
     */
    private String removeSubordinate(String subordinateName) {
        if (((Supervisor) currentUser).removeSubordinate(subordinateName)) {
            users.get(subordinateName).unassignSupervisor();
            return "Remove subordinate successfully!";
        }
        return "Subordinate not found!";
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
        int ch = Integer.parseInt(choice);
        switch (ch - numOfBaseFunc) {
            case 0:
                return "Please enter the user name:";
            case 1:
                return "Please enter the user name:";
            case 2:
                return "Please enter the user name:";
            case 3:
                return "";
        }
        return super.validateChoiceGetFuncDetail(choice);
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
        int ch = Integer.parseInt(choice);
        switch (ch - numOfBaseFunc) {
            case 0:
                return isMySubordinate(values[0]);
            case 1:
                return addSubordinate(values[0]);
            case 2:
                return removeSubordinate(values[0]);
            case 3:
                return getMySubordinatesDetails();
        }
        return super.choiceHandler(choice, values);
    }

    /**
     * Clear current user session in controller
     */
    @Override
    public void clear() {
        super.clear();
        users = null;
    }
}
