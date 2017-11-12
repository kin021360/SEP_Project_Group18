package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.datastructure_interface.*;

public class SupervisorController extends UserController {
    private Supervisor currentSupervisor;

    public SupervisorController(Supervisor supervisor) {
        super(supervisor);
        currentUser = supervisor;
    }

    public boolean isMySubordinate(IUserInfo userInfo){
        return currentSupervisor.isMySubordinate(userInfo);
    }
}
