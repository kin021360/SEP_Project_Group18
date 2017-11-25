package usermanagementsystem.datastructure;

import java.util.Hashtable;

import usermanagementsystem.datastructure_interface.*;

public class Supervisor extends User implements ISupervisorInfo {
    private Hashtable<String, IUserInfo> subordinates;

    public Supervisor(String userName, String password, EnumGender gender, EnumPosition position, long staffId, String email, EnumDepartment departmentOf, ISupervisorInfo supervisor, boolean isAdmin) {
        super(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
        subordinates = new Hashtable<>();
    }

    @Override
    public boolean isMySubordinate(String subordinateName) {
        return subordinates.containsKey(subordinateName);
    }

    public void addSubordinate(IUserInfo subordinate) {
        if (subordinates == null) {
            subordinates = new Hashtable<>();
        }
        subordinates.put(subordinate.getUserName(), subordinate);
    }

    public void removeSubordinate(String subordinateName) {
        subordinates.remove(subordinateName);
    }

    @Override
    public boolean isSupervisor() {
        return true;
    }

    @Override
    public Supervisor toSupervisor() {
        return null;
    }

    public static class SupervisorBuilder extends UserBuilder {
        @Override
        public Supervisor build() {
            return new Supervisor(userName, password, gender, position, staffId, email, departmentOf, supervisor, isAdmin);
        }
    }
}
