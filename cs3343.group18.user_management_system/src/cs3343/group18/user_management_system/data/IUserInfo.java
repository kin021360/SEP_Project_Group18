package cs3343.group18.user_management_system.data;

/**
 * Created by nathanlam on 24/10/2017.
 */
public interface IUserInfo {
    String getUserName();
    boolean checkPassword(String input);
    int getStaffId();
    EnumPosition getPosition();
    String getEmail();
    String showAllPermissions();
    ISupervisorInfo getSupervisorInfo();
    //TODO
}
