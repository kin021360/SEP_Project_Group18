package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidChoice;
import usermanagementsystem.exception.ExIsNullOrEmpty;

import java.util.Hashtable;

/**
 * The Controller class for administrator.
 */
public class AdminController extends UserController {
    private Hashtable<String, User> users;
    private Hashtable<String, Supervisor> supervisors;
    private int numOfBaseFunc;
    private static AdminController instance = new AdminController();

    private AdminController() {
        super();
        numOfBaseFunc = funcChoicesDescriptions.size();
        ControllerHelper.initAdminChoicesDescriptions(funcChoicesDescriptions);
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

    private String createSupervisorAndAdd(String userName, String password, String gender, String position, String email, String departmentOf, String isAdmin) throws ExInvaildEnumValue, ExIsNullOrEmpty {
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

    private String removeUserOrSupervisor(String userName) {
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

    private String upgradeToSupervisor(String userName) {
        if (userName != null && users.containsKey(userName) && !supervisors.containsKey(userName)) {
            User u = users.get(userName);
            users.remove(userName);
            supervisors.put(userName, u.toSupervisor());
            return "Upgrade User to Supervisor successfully!";
        }
        return "User not found!";
    }

    private String addUserPermission(String userName, String permission) throws ExInvaildEnumValue {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.addPermission(EnumPermission.parse(permission));
            return "Permission added!";
        }
        return "User not found!";
    }

    private String removeUserPermission(String userName, String permission) throws ExInvaildEnumValue {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.removePermission(EnumPermission.parse(permission));
            return "Permission removed!";
        }
        return "User not found!";
    }

    private String getAllUserDetails() {
        String detailList = "All users details:\nUser Name      Gender   Email                   Position        My Department        My Supervisor\n";
        for (User u : users.values()) {
            detailList += u.toString() + "\n";
        }
        return detailList;
    }

    private String getAllSupervisorDetails() {
        String detailList = "All supervisors details:\nUser Name      Gender   Email                   Position        My Department        My Supervisor\n";
        for (User u : supervisors.values()) {
            detailList += u.toString() + "\n";
        }
        return detailList;
    }

    private String getAllPeopleDetails() {
        return getAllUserDetails() + "\n" + getAllSupervisorDetails();
    }

    public String getUserDetails(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            return "User Name      Gender   Email                   Position        My Department        My Supervisor\n" + u.toString();
        }
        return "User not found!";
    }

    public String viewAUserPermission(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            return "Current Permission: \nName of Permission       Id\n" + u.showAllPermissions();
        }
        return "User not found!";
    }

    private String resetUserPassword(String userName) {
        User u = getUserOrSupervisor(userName);
        if (u != null) {
            u.changePassword("123456");
            return u.getUserName() + "'s password have reset to '123456'. Please notify the user to change their password.";
        }
        return "User not found!";
    }

    /**
     * Validate the choice and get choice detail
     *
     * @param choice string number, 0 based
     * @return string description for the choice, can be empty string
     * @throws ExInvalidChoice no existing choice in controller
     */
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
            case 10:
                return "Please enter the user name";
            case 11:
                return "Please enter the user name";
            case 12:
                return "";
            case 13:
                return "";
            case 14:
                return "";
        }
        return super.validateChoiceGetFuncDetail(choice);
    }

    /**
     * Involve the action based on the choice
     *
     * @param choice string number, 0 based
     * @param values for the choice, in string array / string array param
     * @return string message
     * @throws Exception include the message that the action cannot be executed
     */
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
            case 10:
                return getUserDetails(values[0]);
            case 11:
                return viewAUserPermission(values[0]);
            case 12:
                return EnumDepartment.listAll();
            case 13:
                return EnumPermission.listAll();
            case 14:
                return EnumPosition.listAll();
        }
        return super.choiceHandler(choice, values);
    }

    /**
     * Clear current user session in controller
     */
    @Override
    public void clear() {
        super.clear();
        users = null;
        supervisors = null;
    }
}
