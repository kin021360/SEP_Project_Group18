package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

public class SupervisorController extends UserController {
    private static SupervisorController instance = new SupervisorController();
    private int numOfBaseFunc;

    private SupervisorController() {
        super();
        numOfBaseFunc = funcChoicesDescriptions.size();
        funcChoicesDescriptions.add("Check a user who is my subordinate or not.");
    }

    public static SupervisorController getInstance(Supervisor user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        return instance;
    }

    public String isMySubordinate(String userName) {
        if (((Supervisor) currentUser).isMySubordinate(userName)) {
            return userName + " is your subordinate.";
        }
        return userName + " is not your subordinate.";
    }

    @Override
    public String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice {
        int ch = Integer.parseInt(choice);
        switch (ch - numOfBaseFunc) {
            case 0:
                return "Please enter the user name:";
        }
        return super.validateChoiceGetFuncDetail(choice);
    }

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
