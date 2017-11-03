package usermanagementsystem.data;

/**
 * Created by nathanlam on 24/10/2017.
 */
public interface ISupervisorInfo extends IUserInfo {
    boolean isMySubordinate(IUserInfo subordinate);
}
