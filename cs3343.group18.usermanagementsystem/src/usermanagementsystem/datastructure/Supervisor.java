package usermanagementsystem.datastructure;

import java.util.HashSet;

import usermanagementsystem.datastructure_interface.*;

public class Supervisor extends User implements ISupervisorInfo {
    private HashSet<IUserInfo> subordinates;

    public Supervisor(String userName, String password, EnumGender gender, EnumPosition position, int staffId, String email, EnumDepartment departmentOf, boolean isAdmin) {
        super(userName, password, gender, position, staffId, email, departmentOf, null, isAdmin);
        subordinates = new HashSet<>();
    }

    @Override
    public boolean isMySubordinate(IUserInfo subordinate) {
        return subordinates.contains(subordinate);
    }

    public void addSubordinate(IUserInfo subordinate) {
        if (subordinates == null) {
            subordinates = new HashSet<>();
        }
        subordinates.add(subordinate);
    }

    public void removeSubordinate(IUserInfo subordinate) {
        subordinates.remove(subordinate);
    }

    @Override
    public boolean isSupervisor() {
        return true;
    }
}
