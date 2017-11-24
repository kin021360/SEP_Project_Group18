package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExControllerInitWithNull;

public class SupervisorController extends UserController {
    private static SupervisorController instance = new SupervisorController();

    private SupervisorController() {
        super();
        funcChoicesDescriptions.add("ssssssss");
    }

    public static SupervisorController getInstance(Supervisor user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        return instance;
    }

    public boolean isMySubordinate(IUserInfo userInfo) {
        return ((Supervisor) currentUser).isMySubordinate(userInfo);
    }
}
