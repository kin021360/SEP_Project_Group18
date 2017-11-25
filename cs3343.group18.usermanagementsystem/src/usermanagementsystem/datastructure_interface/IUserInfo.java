package usermanagementsystem.datastructure_interface;

import usermanagementsystem.datastructure.*;

/**
 * Created by nathanlam on 24/10/2017.
 */
public interface IUserInfo {
    String getUserName();

    boolean checkPassword(String input);

    EnumGender getGender();

    long getStaffId();

    EnumPosition getPosition();

    String getEmail();

    String showAllPermissions();

    boolean hasPermission(EnumPermission permission);

    EnumDepartment getDepartmentOf();

    ISupervisorInfo getSupervisorInfo();

    boolean isAdmin();

    boolean isSupervisor();
    //TODO
}
