package cs3343.group18.user_management_system.data;

import java.util.HashSet;

public class Supervisor extends User implements ISupervisorInfo{
    private HashSet<IUserInfo> subordinates;

    public Supervisor(String userName, String password, String gender, EnumPosition position, int staffId, String email) {
        super(userName, password, gender, position, staffId, email, null);
        subordinates=new HashSet<>();
    }

    @Override
    public boolean isMySubordinate(IUserInfo user) {
        return subordinates.contains(user);
    }

    public void addSubordinate(IUserInfo user){
        subordinates.add(user);
    }

}
