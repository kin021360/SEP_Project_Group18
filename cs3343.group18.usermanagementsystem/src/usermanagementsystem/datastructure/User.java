package usermanagementsystem.datastructure;

import com.google.gson.annotations.Expose;

import java.util.Calendar;
import java.util.HashSet;
import java.util.StringJoiner;

import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExIsNullOrEmpty;

public class User implements IUserInfo, Comparable<User> {
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
    private long staffId;
    @Expose
    private String email;
    @Expose
    private EnumDepartment departmentOf;
    @Expose
    private boolean isAdmin;
    private ISupervisorInfo supervisor;

    public User(String userName, String password, EnumGender gender, EnumPosition position, long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo supervisor, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.position = position;
        this.staffId = staffId;
        this.email = email;
        this.departmentOf = departmentOf;
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
    
    public boolean removePermission(EnumPermission permission) {
        return permissions.remove(permission);
    }

    @Override
    public long getStaffId() {
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
    public EnumDepartment getDepartmentOf() {
        return departmentOf;
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
    public boolean isSupervisor() {
        return false;
    }

    public Supervisor toSupervisor() {
        return new Supervisor(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
    }

    @Override
    public String toString() {
        String temp = new StringJoiner("-").add(userName).add(gender.toString()).add(position.toString()).add("" + staffId).add(email).add(departmentOf.toString()).toString();
        temp += ", Supervisor = ";
        if (supervisor == null) {
            temp += "null";
        } else {
            temp += supervisor.toString();
        }
        return temp;
    }

    @Override
    public int compareTo(User another) {
        return this.userName.compareTo(another.userName);
    }

    //https://codereview.stackexchange.com/questions/127391/simple-builder-pattern-implementation-for-building-immutable-objects
    //http://www.cnblogs.com/techyc/p/3538359.html
    public static class UserBuilder {
        String userName;
        String password;
        long staffId;
        String email;
        EnumGender gender;
        EnumPosition position;
        EnumDepartment departmentOf;
        boolean isAdmin;
        ISupervisorInfo supervisor = null;

        private void strIsNullOrEmpty(String paramName, String value) throws ExIsNullOrEmpty {
            if (value == null || value.equals("")) {
                throw new ExIsNullOrEmpty(paramName);
            }
        }

        public UserBuilder userName(String userName) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), userName);
            this.userName = userName;
            return this;
        }

        public UserBuilder password(String password) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), password);
            this.password = password;
            return this;
        }

        public UserBuilder email(String email) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), email);
            this.email = email;
            return this;
        }

        public UserBuilder gender(EnumGender gender) {
            this.gender = gender;
            return this;
        }

        public UserBuilder position(EnumPosition position) {
            this.position = position;
            return this;
        }

        public UserBuilder departmentOf(EnumDepartment departmentOf) {
            this.departmentOf = departmentOf;
            return this;
        }

        public UserBuilder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

//        public UserBuilder supervisor(ISupervisorInfo supervisor) {
//            this.supervisor = supervisor;
//            return this;
//        }

        public User build() {
            return new User(userName, password, gender, position, Calendar.getInstance().getTimeInMillis(), email, departmentOf, supervisor, isAdmin);
        }
    }
}
