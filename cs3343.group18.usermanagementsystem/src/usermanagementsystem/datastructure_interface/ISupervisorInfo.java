package usermanagementsystem.datastructure_interface;

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
