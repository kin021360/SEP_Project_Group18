package cs3343.group18.user_management_system.data;

import java.util.ArrayList;

/**
 * Created by Nathan Lam on 23/10/2017.
 */
public class Test {
    private String user_id;
    private String nickname;
    private String gender;
    private int create_time;
    private boolean is_blocked;
    private ArrayList<Integer> item_data;
    private EnumPosition position;
    public Test(String d){
        user_id=d;
    }
}
