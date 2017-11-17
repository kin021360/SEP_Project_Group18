package usermanagementsystem.test;

import org.junit.Test;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.controller.*;

import java.util.Hashtable;

/**
 * Created by Nathan Lam on 12/11/2017.
 */
public class TestController {
    public static void main(String[] args) {
        UserDao userDao = new UserDao("data.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        UserController userController = new SupervisorController(supervisors.get("efg"));
//        System.out.println(userController.getMyDetails());

        AdminController adminController = new AdminController(users.get("james"), users, supervisors);
        adminController.createUserAndAdd("qqq", "111", "Male", EnumPosition.Programmer.toString(), "qqqq@q.com", EnumDepartment.Technology.toString(), "false");

        System.out.println(adminController.getAllResult());
    }

}
