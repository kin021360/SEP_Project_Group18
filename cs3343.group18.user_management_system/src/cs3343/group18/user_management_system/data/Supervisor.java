package cs3343.group18.user_management_system.data;

import java.util.ArrayList;

public class Supervisor extends User implements ISupervisorInfo{
    public Supervisor(String n, String pwd, String gen, EnumPosition po, int sID, String em) {
        super(n, pwd, gen, po, sID, em, null);
    }

    @Override
    public boolean isMySubordinate(IUserInfo subordinate) {
        return false;
    }
}
