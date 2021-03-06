package usermanagementsystem.datastructure;

import java.util.Hashtable;

import usermanagementsystem.datastructure_interface.*;
import usermanagementsystem.exception.ExIsNullOrEmpty;

/**
 * The data type Supervisor. It can be parsed by Gson from json
 */
public class Supervisor extends User implements ISupervisorInfo {
    private Hashtable<String, IUserInfo> subordinates;

    /**
     * The constructor create Supervisor object instance by SupervisorBuilder
     *
     * @param builder SupervisorBuilder
     */
    private Supervisor(SupervisorBuilder builder) {
        super(builder);
        subordinates = new Hashtable<>();
    }

    /**
     * Default constructor
     */
    protected Supervisor() {
        subordinates = new Hashtable<>();
    }

    /**
     * Check the name that who is my subordinate or not
     *
     * @param subordinateName subordinate name
     * @return boolean
     */
    @Override
    public boolean isMySubordinate(String subordinateName) {
        return subordinates.containsKey(subordinateName);
    }

    /**
     * Get Subordinates Details List
     *
     * @return String result list
     */
    @Override
    public String getMySubordinatesDetails() {
        String result = "";
        for (IUserInfo u : subordinates.values()) {
            result += u.toString() + "\n";
        }
        return result;
    }

    /**
     * @param subordinate IUserInfo
     * @return boolean
     */
    public boolean addSubordinate(IUserInfo subordinate) {
        if (subordinates == null) {
            subordinates = new Hashtable<>();
        }
        if (!subordinates.containsKey(subordinate.getUserName())) {
            subordinates.put(subordinate.getUserName(), subordinate);
            return true;
        }
        return false;
    }


    /**
     * Remove subordinate by name
     *
     * @param subordinateName subordinate name
     * @return boolean
     */
    public boolean removeSubordinate(String subordinateName) {
        if (subordinates.containsKey(subordinateName)) {
            subordinates.remove(subordinateName);
            return true;
        }
        return false;
    }

    /**
     * @return true
     */
    @Override
    public boolean isSupervisor() {
        return true;
    }

    /**
     * Override User toSupervisor method the Supervisor cannot recreate new Supervisor again
     *
     * @return null
     */
    @Override
    public Supervisor toSupervisor() {
        return null;
    }

    /**
     * The object builder helps to create new Supervisor object. Inherits <b>UserBuilder</b>
     */
    public static class SupervisorBuilder extends UserBuilder {
        /**
         * The build method to build new Supervisor object
         *
         * @return Supervisor object
         * @throws ExIsNullOrEmpty important data field cannot be null or empty
         */
        @Override
        public Supervisor build() throws ExIsNullOrEmpty {
            validation();
            return new Supervisor(this);
        }
    }
}
