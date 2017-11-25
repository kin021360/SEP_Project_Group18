package usermanagementsystem.datastructure_interface;

import usermanagementsystem.datastructure.*;

/**
 * Created by nathanlam on 24/10/2017.
 */
public interface ISupervisorInfo extends IUserInfo {
    boolean isMySubordinate(String subordinate);
}
