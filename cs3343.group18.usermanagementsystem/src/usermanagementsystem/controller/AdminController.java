package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidChoice;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.util.Hashtable;

public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;
    private int numOfBaseFunc;
    private static AdminController instance = new AdminController();

    private AdminController() {
        super();
        numOfBaseFunc = funcChoicesDescriptions.size();
        funcChoicesDescriptions.add("Create new user.");
        funcChoicesDescriptions.add("Create new supervisor.");
        funcChoicesDescriptions.add("Remove user or supervisor.");
        funcChoicesDescriptions.add("Upgrade existing user to supervisor.");
        funcChoicesDescriptions.add("Add a new permission to user");
        funcChoicesDescriptions.add("Remove the permission from user");
        funcChoicesDescriptions.add("Reset user password");
        funcChoicesDescriptions.add("Print all normal users details");
        funcChoicesDescriptions.add("Print all supervisors details");
        funcChoicesDescriptions.add("Print all people details");
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

    public String getAllUserDetails() {
        String detailList = "All users details:\nUser Name      Gender   Email                   Position        My Department        My Supervisor\n";
        for (User u : users.values()) {
            detailList += u.toString() + "\n";
        }
        return detailList;
    }

    public String getAllSupervisorDetails() {
        String detailList = "All supervisors details:\nUser Name      Gender   Email                   Position        My Department        My Supervisor\n";
        for (User u : supervisors.values()) {
            detailList += u.toString() + "\n";
        }
        return detailList;
    }

    public String getAllPeopleDetails() {
        return getAllUserDetails() + "\n" + getAllSupervisorDetails();
    }

    //modify later---
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
            return u.getUserName() + "'s password have reset to '123456'. Please notify the user to change their password.";
        }
        return "User not found!";
    }

    @Override
    public String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice {
        int ch = Integer.parseInt(choice);
        switch (ch - numOfBaseFunc) {
            case 0:
                return "Please enter the 'user name', 'password', 'gender', 'position', 'email', 'department', 'isAdmin' to create user:";
            case 1:
                return "Please enter the 'user name', 'password', 'gender', 'position', 'email', 'department', 'isAdmin' to create supervisor:";
            case 2:
                return "Please enter the user name to remove user or supervisor:";
            case 3:
                return "Please enter the user name to upgrade user to supervisor:";
            case 4:
                return "Please enter the user name and permission to add permission for user:";
            case 5:
                return "Please enter the user name and permission to remove permission for user:";
            case 6:
                return "Please enter the user name";
            case 7:
                return "";
            case 8:
                return "";
            case 9:
                return "";
        }
        return super.validateChoiceGetFuncDetail(choice);
    }

    @Override
    public String choiceHandler(String choice, String... values) throws Exception {
        int ch = Integer.parseInt(choice);
        switch (ch - numOfBaseFunc) {
            case 0:
                return createUserAndAdd(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
            case 1:
                return createSupervisorAndAdd(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
            case 2:
                return removeUserOrSupervisor(values[0]);
            case 3:
                return upgradeToSupervisor(values[0]);
            case 4:
                return addUserPermission(values[0], values[1]);
            case 5:
                return removeUserPermission(values[0], values[1]);
            case 6:
                return resetUserPassword(values[0]);
            case 7:
                return getAllUserDetails();
            case 8:
                return getAllSupervisorDetails();
            case 9:
                return getAllPeopleDetails();
        }
        return super.choiceHandler(choice, values);
    }

    @Override
    public void clear() {
        super.clear();
        users = null;
        supervisors = null;
    }
}
