package usermanagementsystem.datastructure_interface;

/**
 * Created by nathanlam on 24/10/2017.
 */
public interface ISupervisorInfo extends IUserInfo {
    boolean isMySubordinate(String subordinate);
}
