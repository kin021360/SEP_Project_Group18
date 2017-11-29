package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

/**
 * The Controller class for Supervisor.
 */
public class SupervisorController extends UserController {
    private static SupervisorController instance = new SupervisorController();
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
     * Singleton UserController
     *
     * @param user User
     * @return instance SupervisorController
     * @throws ExControllerInitWithNull the input param cannot be null
     */
    public static SupervisorController getInstance(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
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
        }
        return super.choiceHandler(choice, values);
    }
}
