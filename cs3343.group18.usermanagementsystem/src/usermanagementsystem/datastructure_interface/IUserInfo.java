package usermanagementsystem.datastructure_interface;

import usermanagementsystem.datastructure.*;

/**
 * Created by nathanlam on 24/10/2017.
 */

/**
 * The interface for <b>User</b> . Provide general get access for <b>User</b>
 */
public interface IUserInfo {
    /**
     * @return the user name
     */
    String getUserName();

    /**
     * Checking input password value which is correct or not.
     *
     * @param input password
     * @return boolean
     */
    boolean checkPassword(String input);

    /**
     * @return EnumGender
     */
    EnumGender getGender();

    /**
     * @return staffId
     */
    long getStaffId();

    /**
     * @return EnumPosition
     */
    EnumPosition getPosition();

    /**
     * @return email
     */
    String getEmail();

    /**
     * @return the User's permissions list in string
     */
    String showAllPermissions();

    /**
     * Check User have this permission or not
     *
     * @param permission EnumPermission
     * @return boolean
     */
    boolean hasPermission(EnumPermission permission);

    /**
     * @return which department that User belong to
     */
    EnumDepartment getDepartmentOf();

    /**
     * @return User's Supervisor
     */
    ISupervisorInfo getSupervisorInfo();

    /**
     * @return boolean isAdmin
     */
    boolean isAdmin();

    /**
     * @return boolean isSupervisor
     */
    boolean isSupervisor();
}
