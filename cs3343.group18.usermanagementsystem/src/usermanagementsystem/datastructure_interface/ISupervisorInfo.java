package usermanagementsystem.datastructure_interface;

/**
 * Created by nathanlam on 24/10/2017.
 */

/**
 * The interface for <b>Supervisor</b> . Provide general get access for <b>Supervisor</b>
 */
public interface ISupervisorInfo extends IUserInfo {
    /**
     * Check the name that who is my subordinate or not
     *
     * @param subordinate subordinate name
     * @return boolean
     */
    boolean isMySubordinate(String subordinate);
}
