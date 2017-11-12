package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;

import java.util.Hashtable;

public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;

    public AdminController(User admin, Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) {
        super(admin);
        this.users = users;
        this.supervisors = supervisors;
    }


}
