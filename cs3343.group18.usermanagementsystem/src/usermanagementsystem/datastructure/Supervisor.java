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
     * The constructor create Supervisor object instance by following params
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
     * @param loginFailTime    		(Integer)
     * @param suspensionTimeStamp   (long)
     * @param annualLeave      		(Integer)
     */
    protected Supervisor(String userName, String password, EnumGender gender, EnumPosition position, long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo supervisor, boolean isAdmin) {
        super(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
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
     * @param subordinate IUserInfo
     */
    public void addSubordinate(IUserInfo subordinate) {
        if (subordinates == null) {
            subordinates = new Hashtable<>();
        }
        subordinates.put(subordinate.getUserName(), subordinate);
    }

    /**
     * Remove my subordinate by name
     *
     * @param subordinateName subordinate name
     */
    public void removeSubordinate(String subordinateName) {
        subordinates.remove(subordinateName);
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
            return new Supervisor(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
        }
    }
}
