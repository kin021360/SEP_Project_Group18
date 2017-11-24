package usermanagementsystem.test;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.controller.*;

import java.util.Hashtable;

/**
 * Created by Nathan Lam on 12/11/2017.
 */
public class TestController {
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao("data.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        UserController userController = SupervisorController.getInstance(supervisors.get("efg"));
//        System.out.println(userController.getMyDetails());

        AdminController adminController = AdminController.getInstance(users.get("james"), users, supervisors);
        adminController.createUserAndAdd("qqq", "111", "Male", EnumPosition.Programmer.toString(), "qqqq@q.com", EnumDepartment.Technology.toString(), "false");

        System.out.println(adminController.getAllResult());

        System.out.println(adminController.getDepartmentDoc("qqq"));

        System.out.println(userController.getAllFunctionsDesc());
        System.out.println(adminController.getAllFunctionsDesc());
    }
}
