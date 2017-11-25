package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.util.Hashtable;

public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;

    public AdminController(User admin, Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) throws ExControllerInitWithNull {
        super(admin.isAdmin() ? admin : null);
        this.users = users;
        this.supervisors = supervisors;
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

    public String createUserAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) throws ExInvaildEnumValue, ExIsNullOrEmpty {
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
            return "Create User successfully!";
        }
        return "User is already existed!";
    }

    public String createSupervisorAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) throws ExInvaildEnumValue, ExIsNullOrEmpty {
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
            return "Create Supervisor successfully!";
        }
        return "Supervisor is already existed!";
    }

    public String removeUserOrSupervisor(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            if (u.isSupervisor()) {
                supervisors.remove(userName);
            } else {
                users.remove(userName);
            }
            return "Remove User successfully!";
        }
        return "User not found!";
    }

    public String upgradeToSupervisor(String userName) {
        if (userName != null && users.containsKey(userName) && !supervisors.containsKey(userName)) {
            User u = users.get(userName);
            users.remove(userName);
            supervisors.put(userName, u.toSupervisor());
            return "Upgrade User to Supervisor successfully!";
        }
        return "User not found!";
    }

    public String addUserPermission(String userName, String permission) throws ExInvaildEnumValue {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.addPermission(EnumPermission.parse(permission));
            return "Permission added!";
        }
        return "User not found!";
    }

    public String removeUserPermission(String userName, String permission) throws ExInvaildEnumValue {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.removePermission(EnumPermission.parse(permission));
            return "Permission removed!";
        }
        return "User not found!";
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

    //comment for modify this function below -- modify later---
//    public String getUserDetails(String userName) {
//        User u = getUserOrSupervisor(userName);
//        if (u != null) {
//            return u.toString();
//        }
//        return "User not found!";
//    }

    public String getUserDetails(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            String[] userInfoArr = u.toString().split("-");
            String[] departmentSupervisor = userInfoArr[5].split(", Supervisor = ");
            return String.format("Username: %s\n Password: %s\n Sex: %s\n Email: %s\n Position: %s\n Department: %s\n Supervisor: %s\n",
                    userInfoArr[0], userInfoArr[3], userInfoArr[1], userInfoArr[4], userInfoArr[2], departmentSupervisor[0], departmentSupervisor[1]);
        }
        return "User not found!";
    }

    public String listAUserPermission(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            String[] userPermissionArr = u.showAllPermissions().split(",");
            int permissionId = 0;
            String temp = "Current Permission: \n Name of Permission       Id\n";
            for (String e : userPermissionArr) {
                temp += String.format("%18s  ---  %2d\n", e, permissionId);
                permissionId++;
            }
            return temp;
        }
        return "User not found!";
    }
    //modify later---

    public String resetUserPassword(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.changePassword("123456");
            return u.getUserName() + "'s password have reset to 123456. Please notify the user to change their password.";
        }
        return "User not found!";
    }

    @Override
    public void destroy() {
        super.destroy();
        users = null;
        supervisors = null;
    }
}
