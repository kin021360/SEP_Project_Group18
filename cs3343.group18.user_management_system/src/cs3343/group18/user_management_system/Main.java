package cs3343.group18.user_management_system;

import cs3343.group18.user_management_system.data.*;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        // TODO console input interface. No need un-do, re-do command <- very troublesome
        System.out.println("test main");


        //sample example to load users based on data.json
        UserDao userDao = new UserDao();

        //load User list(Hashtable) without mapping their Supervisor yet
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        System.out.println(users.get("abc").toString());

        //load Supervisor list(Hashtable) without mapping their Subordinate(下屬/normal user) yet
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        System.out.println(supervisors.get("efg").toString());

        //Map User and Supervisor
        userDao.mapUserSupervisor(users, supervisors);
        System.out.println(users.get("abc").toString());

        users.get("abc").changePassword("999999999999999999555");
        supervisors.get("efg").changePassword("777777777777777");
        userDao.updateAndSave(users, supervisors);
    }
}
