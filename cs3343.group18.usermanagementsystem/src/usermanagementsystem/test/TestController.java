package usermanagementsystem.test;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;
import usermanagementsystem.controller.*;

import java.io.BufferedInputStream;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Nathan Lam on 12/11/2017.
 */
public class TestController {
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao("data.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        userDao.mapUserSupervisor(users, supervisors);
        UserController userController = SupervisorController.getInstance(supervisors.get("efg"));
//        System.out.println(userController.getMyDetails());

        AdminController adminController = AdminController.getInstance(users.get("admin"), users, supervisors);
        adminController.createUserAndAdd("qqq", "111", "Male", EnumPosition.Programmer.toString(), "qqqq@q.com", EnumDepartment.Technology.toString(), "false");

        System.out.println(adminController.getUserDetails("test2"));

        System.out.println(supervisors.get("efg").getMySubordinatesDetails());
        String[] r = new String[]{"abc"};
//        System.out.println(adminController.choiceHandler("10", "abc"));

//        Scanner stdin = new Scanner(System.in);
//        while (stdin.hasNext()) {
//            System.out.println(stdin.next());
//        }
    }
}
