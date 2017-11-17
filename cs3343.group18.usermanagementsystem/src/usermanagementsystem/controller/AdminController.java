package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;

import java.util.Hashtable;

public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;

    public AdminController(User admin, Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) {
        super(admin.isAdmin() ? admin : null);
        this.users = users;
        this.supervisors = supervisors;
    }

    private User getUserOrSupervisor(String userName) {
        if (users.containsKey(userName)) {
            return users.get(userName);
        } else if (supervisors.containsKey(userName)) {
            return supervisors.get(userName);
        }
        return null;
    }

    public boolean createUserAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) {
        if (!users.containsKey(userName)) {
            User.UserBuilder builder = new User.UserBuilder();
            builder.userName(userName)
                    .password(password)
                    .gender(EnumGender.parse(gender))
                    .position(EnumPosition.parse(position))
                    .email(email)
                    .departmentOf(EnumDepartment.parse(departmentOf))
                    .isAdmin(Boolean.valueOf(isAdmin));
            users.put(userName, builder.build());
        }
        return false;
    }

    public boolean createSupervisorAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) {
        if (!supervisors.containsKey(userName)) {
            Supervisor.SupervisorBuilder builder = new Supervisor.SupervisorBuilder();
            builder.userName(userName)
                    .password(password)
                    .gender(EnumGender.parse(gender))
                    .position(EnumPosition.parse(position))
                    .email(email)
                    .departmentOf(EnumDepartment.parse(departmentOf))
                    .isAdmin(Boolean.valueOf(isAdmin));
            supervisors.put(userName, builder.build());
        }
        return false;
    }

    public boolean removeUserOrSupervisor(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            if (u.isSupervisor()) {
                supervisors.remove(userName);
            } else {
                users.remove(userName);
            }
            return true;
        }
        return false;
    }

    public boolean upgradeToSupervisor(String userName) {
        if (users.containsKey(userName) && !supervisors.containsKey(userName)) {
            User u = users.get(userName);
            users.remove(userName);
            supervisors.put(userName, u.toSupervisor());
        }
        return false;
    }

    public boolean addPermissionToUser(String userName, String permission) {
        User u = getUserOrSupervisor(userName);
        EnumPermission p = EnumPermission.parse(permission);
        if (u != null && p != null) {
            u.addPermission(p);
            return true;
        }
        return false;
    }

    public String getUserListResult() {

        return "";
    }

    public String getSupervisorListResult() {

        return "";
    }

    public String getAllResult() {
        String resultList = "";
        for (User u : users.values()) {
            resultList += u.toString() + "\n";
        }
        for (User u : supervisors.values()) {
            resultList += u.toString() + "\n";
        }
        return resultList;
    }

    public String getUserDetails(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            return u.toString();
        }
        return "User not found!";
    }
}
