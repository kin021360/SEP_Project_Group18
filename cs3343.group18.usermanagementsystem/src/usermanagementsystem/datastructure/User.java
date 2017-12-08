package usermanagementsystem.datastructure;

import com.google.gson.annotations.Expose;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExIsNullOrEmpty;

/**
 * The data type User. It can be parsed by Gson from json
 */
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
    @Expose
    private int loginFailTime;
    @Expose
    private long suspensionTimeStamp;
    @Expose
    private int annualLeave;
    @Expose
    private HashSet<String> annualLeaveInfos;
    private ISupervisorInfo supervisor;

    /**
     * The constructor create User object instance by following params
     *
     * @param userName     (String)
     * @param password     (String)
     * @param gender       (EnumGender)
     * @param position     (EnumPosition)
     * @param staffId      (long)
     * @param email        (String)
     * @param departmentOf (EnumDepartment)
     * @param supervisor   (ISupervisorInfo)
     * @param isAdmin      (boolean)
     */
    protected User(String userName, String password, EnumGender gender, EnumPosition position, long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo supervisor, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.position = position;
        this.staffId = staffId;
        this.email = email;
        this.departmentOf = departmentOf;
        this.supervisor = supervisor;
        this.isAdmin = isAdmin;
        this.loginFailTime = 0;
        this.suspensionTimeStamp = 0;
        this.annualLeave = 12;
        this.annualLeaveInfos = new HashSet<>();
        this.permissions = new HashSet<>();
    }

    /**
     * Default constructor
     */
    protected User() {

    }

    /**
     * @return the user name
     */
    @Override
    public String getUserName() {
        return userName;
    }

    /**
     * Checking input password value which is correct or not.
     *
     * @param input password
     * @return boolean
     */
    @Override
    public boolean checkPassword(String input) {
        return input.equals(password);
    }

    /**
     * @return EnumGender
     */
    @Override
    public EnumGender getGender() {
        return gender;
    }

    /**
     * Change User's password
     *
     * @param password password
     */
    public void changePassword(String password) {
        this.password = password;
    }

    /**
     * Add more permission into User if that permission is not exist
     *
     * @param permission EnumPermission
     * @return boolean
     */
    public boolean addPermission(EnumPermission permission) {
        return permissions.add(permission);
    }

    /**
     * Remove the permission from User if that permission is exist
     *
     * @param permission EnumPermission
     * @return boolean
     */
    public boolean removePermission(EnumPermission permission) {
        return permissions.remove(permission);
    }

    /**
     * @return staffId
     */
    @Override
    public long getStaffId() {
        return staffId;
    }

    /**
     * @return EnumPosition
     */
    @Override
    public EnumPosition getPosition() {
        return position;
    }

    /**
     * @return email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * @return the User's permissions list in string
     */
    @Override
    public String showAllPermissions() {
        String temp = "";
        for (EnumPermission permission : permissions) {
            temp += String.format("%18s  ---  %2d\n", permission.name(), permission.getId());
        }
        return temp;
    }

    /**
     * Check User have this permission or not
     *
     * @param permission EnumPermission
     * @return boolean
     */
    @Override
    public boolean hasPermission(EnumPermission permission) {
        return permissions.contains(permission);
    }

    /**
     * @return which department that User belong to
     */
    @Override
    public EnumDepartment getDepartmentOf() {
        return departmentOf;
    }

    /**
     * @return User's Supervisor
     */
    @Override
    public ISupervisorInfo getSupervisorInfo() {
        return supervisor;
    }

    /**
     * @return User's number of login fail
     */
    @Override
    public int getLoginFailTime() {
        return loginFailTime;
    }

    /**
     * @return User's suspension time stamp
     */
    @Override
    public long getSuspensionTimeStamp() {
        return suspensionTimeStamp;
    }

    /**
     * @return User's number of annual leave
     */
    @Override
    public int getAnnualLeave() {
        return annualLeave;
    }

    /**
     * Increase User's number of login fail
     *
     * @param loginFailTime loginFailTime
     */
    public void setLoginFailTime(int loginFailTime) {
        this.loginFailTime = loginFailTime;
    }

    /**
     * Set User's suspension time stamp
     *
     * @param suspensionTimeStamp suspensionTimeStamp
     */
    public void setSuspensionTimeStamp(long suspensionTimeStamp) {
        this.suspensionTimeStamp = suspensionTimeStamp;
    }

    /**
     * Set User's number of annual leave
     *
     * @param annualLeave annualLeave
     */
    public void setAnnualLeave(int annualLeave) {
        this.annualLeave += annualLeave;
    }

    /**
     * Add more annual leave information into User
     *
     * @param annualLeaveInfo AnnualLeaveInfo
     * @return boolean
     */
    public boolean addAnnualLeaveInfo(AnnualLeaveInfo annualLeaveInfo, String annualLeaveInfoString) {
        this.annualLeave -= annualLeaveInfo.getDayOfAnnualLeave();
        return annualLeaveInfos.add(annualLeaveInfoString);
    }

    /**
     * @return User's annual leave information
     */
    @Override
    public String showAllAnnualLeaveInfos() {
        String temp = "";
        temp += String.format("%s%15s%15s\n", "Day(s)", "Start Date", "End Date");
        if (annualLeaveInfos.size() > 0) {
            for (String annualLeaveInfo : annualLeaveInfos) {
                String[] infoArray = annualLeaveInfo.split(" ");
                Date startDate = new Date(Long.parseLong(infoArray[1]));
                Date endDate = new Date(Long.parseLong(infoArray[2]));
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String startDateFormat = sdf.format(startDate);
                String endDateFormat = sdf.format(endDate);
                temp += String.format("%s%20s%17s\n", infoArray[0], startDateFormat, endDateFormat);
            }
        } else {
            temp = "You have no annual leave!";
        }
        return temp;
    }

    /**
     * @return User's annual leave information
     */
    @Override
    public HashSet<String> getAnnualLeaveInfos() {
        return annualLeaveInfos;
    }

    /**
     * Assign Supervisor for User if User have no Supervisor
     *
     * @param supervisor ISupervisorInfo
     * @return boolean
     */
    public boolean assignSupervisor(ISupervisorInfo supervisor) {
        if (this.supervisor == null && supervisor != null) {
            this.supervisor = supervisor;
            return true;
        }
        return false;
    }

    /**
     * Remove User's Supervisor
     */
    public void unassignSupervisor() {
        this.supervisor = null;
    }

    /**
     * @return boolean isAdmin
     */
    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * @return false
     */
    @Override
    public boolean isSupervisor() {
        return false;
    }

    /**
     * Create new Supervisor based on this User
     *
     * @return Supervisor
     */
    public Supervisor toSupervisor() {
        User tSupervisor = new Supervisor();
        //construct manually
        tSupervisor.userName = userName;
        tSupervisor.password = password;
        tSupervisor.gender = gender;
        tSupervisor.position = position;
        tSupervisor.staffId = staffId;
        tSupervisor.email = email;
        tSupervisor.departmentOf = departmentOf;
        tSupervisor.supervisor = supervisor;
        tSupervisor.isAdmin = isAdmin;
        tSupervisor.loginFailTime = loginFailTime;
        tSupervisor.suspensionTimeStamp = suspensionTimeStamp;
        tSupervisor.annualLeave = annualLeave;
        tSupervisor.annualLeaveInfos = annualLeaveInfos;
        tSupervisor.permissions = permissions;
        return (Supervisor) tSupervisor;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-9s%-24s%-16s%-21s%s", userName, gender.name(), email, position.name(), departmentOf.name(), supervisor == null ? null : supervisor.getUserName());
    }

    @Override
    public int compareTo(User another) {
        return this.userName.compareTo(another.userName);
    }

    //https://codereview.stackexchange.com/questions/127391/simple-builder-pattern-implementation-for-building-immutable-objects
    //http://www.cnblogs.com/techyc/p/3538359.html

    /**
     * The object builder helps to create new User object.
     */
    public static class UserBuilder {
        String userName;
        String password;
        long staffId = Calendar.getInstance().getTimeInMillis();
        String email;
        EnumGender gender;
        EnumPosition position;
        EnumDepartment departmentOf;
        boolean isAdmin = false;
        ISupervisorInfo supervisor = null;

        /**
         * Check the string value is null or empty
         *
         * @param paramName original method's param name
         * @param value     string value
         * @throws ExIsNullOrEmpty string is null or empty
         */
        private void strIsNullOrEmpty(String paramName, String value) throws ExIsNullOrEmpty {
            if (value == null || value.equals("")) {
                throw new ExIsNullOrEmpty(paramName);
            }
        }

        /**
         * The user name setter of UserBuilder
         *
         * @param userName user name
         * @return UserBuilder
         * @throws ExIsNullOrEmpty string is null or empty
         */
        public UserBuilder userName(String userName) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), userName);
            this.userName = userName;
            return this;
        }

        /**
         * The password setter of UserBuilder
         *
         * @param password password
         * @return UserBuilder
         * @throws ExIsNullOrEmpty string is null or empty
         */
        public UserBuilder password(String password) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), password);
            this.password = password;
            return this;
        }

        /**
         * The email setter of UserBuilder
         *
         * @param email email
         * @return UserBuilder
         * @throws ExIsNullOrEmpty string is null or empty
         */
        public UserBuilder email(String email) throws ExIsNullOrEmpty {
            strIsNullOrEmpty(Thread.currentThread().getStackTrace()[1].getMethodName(), email);
            this.email = email;
            return this;
        }

        /**
         * The gender setter of UserBuilder
         *
         * @param gender EnumGender
         * @return UserBuilder
         */
        public UserBuilder gender(EnumGender gender) {
            this.gender = gender;
            return this;
        }

        /**
         * The position setter of UserBuilder
         *
         * @param position EnumPosition
         * @return UserBuilder
         */
        public UserBuilder position(EnumPosition position) {
            this.position = position;
            return this;
        }

        /**
         * The departmentOf setter of UserBuilder
         *
         * @param departmentOf EnumDepartment
         * @return UserBuilder
         */
        public UserBuilder departmentOf(EnumDepartment departmentOf) {
            this.departmentOf = departmentOf;
            return this;
        }

        /**
         * The isAdmin setter of UserBuilder
         *
         * @param isAdmin isAdmin
         * @return UserBuilder
         */
        public UserBuilder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        /**
         * Validate important data field
         *
         * @throws ExIsNullOrEmpty important data field cannot be null or empty
         */
        protected void validation() throws ExIsNullOrEmpty {
            strIsNullOrEmpty("userName", userName);
            strIsNullOrEmpty("password", password);
            strIsNullOrEmpty("email", email);
            if (gender == null) throw new ExIsNullOrEmpty("gender");
            if (position == null) throw new ExIsNullOrEmpty("position");
            if (departmentOf == null) throw new ExIsNullOrEmpty("departmentOf");
        }

        /**
         * The build method to build new User object
         *
         * @return User object
         * @throws ExIsNullOrEmpty important data field cannot be null or empty
         */
        public User build() throws ExIsNullOrEmpty {
            //verify
            validation();
            return new User(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
        }
    }
}
