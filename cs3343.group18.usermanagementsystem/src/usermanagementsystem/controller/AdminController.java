package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.util.Hashtable;

public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;
    private static AdminController instance = new AdminController();

    private AdminController() {
        super();
        funcChoicesDescriptions.add("aaaaaa");
    }

    public static AdminController getInstance(User admin, Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) throws ExControllerInitWithNull {
        if (admin == null) throw new ExControllerInitWithNull();
        if (users == null || supervisors == null) throw new ExControllerInitWithNull();
        instance.currentUser = admin;
        instance.users = users;
        instance.supervisors = supervisors;
        return instance;
    }

    private User getUserOrSupervisor(String userName) {
        if (userName == null) return null;
        if (users.containsKey(userName)) {
            return users.get(userName);
        } else if (supervisors.containsKey(userName)) {
            return supervisors.get(userName);
        }
        return null;
    }

    public boolean createUserAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) throws ExInvaildEnumValue, ExIsNullOrEmpty {
        if (userName != null && !users.containsKey(userName)) {
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

    public boolean createSupervisorAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) throws ExInvaildEnumValue, ExIsNullOrEmpty {
        if (userName != null && !supervisors.containsKey(userName)) {
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
        if (userName != null && users.containsKey(userName) && !supervisors.containsKey(userName)) {
            User u = users.get(userName);
            users.remove(userName);
            supervisors.put(userName, u.toSupervisor());
        }
        return false;
    }

    public boolean addPermissionToUser(String userName, String permission) throws ExInvaildEnumValue {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.addPermission(EnumPermission.parse(permission));
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

    @Override
    public void clear() {
        super.clear();
        users = null;
        supervisors = null;
    }
}
