package cs3343.group18.user_management_system;

import cs3343.group18.user_management_system.data.*;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        // TODO interface
        System.out.println("test main");
        UserDao userdao = new UserDao();
        Hashtable<String, User> users=userdao.loadUsers();


        System.out.println();
    }
}
