package cs3343.group18.user_management_system.data;

import com.google.gson.annotations.Expose;

import java.util.HashSet;
import java.util.StringJoiner;

public class User implements IUserInfo {
    @Expose
    private String userName;
    @Expose
    private String password;
    @Expose
    private EnumGender gender;
    @Expose
    private EnumPosition position;
    @Expose
    private HashSet<EnumPermission> permissions;
    @Expose
    private int staffId;
    @Expose
    private String email;
    @Expose
    private boolean isAdmin;
    private ISupervisorInfo supervisor;

    public User(String userName, String password, EnumGender gender, EnumPosition position, int staffId, String email, ISupervisorInfo supervisor, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.position = position;
        this.staffId = staffId;
        this.email = email;
        this.supervisor = supervisor;
        this.isAdmin = isAdmin;
        this.permissions = new HashSet<>();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    @Override
    public EnumGender getGender() {
        return gender;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public boolean addPermission(EnumPermission permission) {
        return permissions.add(permission);
    }

    @Override
    public int getStaffId() {
        return staffId;
    }

    @Override
    public EnumPosition getPosition() {
        return position;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String showAllPermissions() {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (EnumPermission permission : permissions) {
            stringJoiner.add(permission.toString());
        }
        return stringJoiner.toString();
    }

    @Override
    public boolean hasPermission(EnumPermission permission) {
        return permissions.contains(permission);
    }

    @Override
    public ISupervisorInfo getSupervisorInfo() {
        return supervisor;
    }

    public boolean assignSupervisor(ISupervisorInfo supervisor) {
        if (this.supervisor == null) {
            this.supervisor = supervisor;
            return true;
        }
        return false;
    }

    public void unassignSupervisor() {
        this.supervisor = null;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {
        String temp = new StringJoiner("-").add(userName).add(gender.toString()).add(position.toString()).add("" + staffId).add(email).toString();
        temp += ", Supervisor = ";
        if (supervisor == null) {
            temp += "null";
        } else {
            temp += supervisor.toString();
        }
        return temp;
    }
}
