package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExControllerInitWithNull;

public class SupervisorController extends UserController {
    private Supervisor currentSupervisor;

    public SupervisorController(Supervisor supervisor) throws ExControllerInitWithNull {
        super(supervisor);
        currentUser = supervisor;
    }

    public boolean isMySubordinate(IUserInfo userInfo) {
        return currentSupervisor.isMySubordinate(userInfo);
    }
}
