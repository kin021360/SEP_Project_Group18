package cs3343.group18.user_management_system.data;

import com.sun.org.apache.bcel.internal.generic.IUSHR;

import javax.lang.model.element.NestingKind;

public class User implements IUserInfo {

    private String name;
    private String password;
    private String gender;
    EnumPosition position;
    private int staffId;
    private String email;

    public User(String n, String pwd, String gen, EnumPosition po, int sID, String em) {
        name = n;
        password = pwd;
        gender = gen;
        position = po;
        staffId = sID;
        email = em;
    }


    public String getUserName() {
        return name;
    }


    public boolean checkPassword(String input) {
        if (input == password)
            return true;
        else
            return false;
    }

    public int getStaffId() {
        return staffId;
    }


    public EnumPosition getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    //Need to revise
  public  String showAllPermissions(){
     return null;
  }
    //Need to revise
    public ISupervisorInfo getSupervisorInfo(){
      return  null;
    }


}
