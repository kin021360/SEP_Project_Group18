package cs3343.group18.user_management_system.data;


public class User implements IUserInfo {

    private String userName;
    private String password;
    private String gender;
    EnumPosition position;
    private int staffId;
    private String email;
    private ISupervisorInfo supervisor;

    public User(String userName, String password, String gender, EnumPosition position, int staffId, String email, ISupervisorInfo supervisor) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.position = position;
        this.staffId = staffId;
        this.email = email;
        this.supervisor = supervisor;
    }


    public String getUserName() {
        return userName;
    }


    public boolean checkPassword(String input) {
        return input.equals(password);
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
    public String showAllPermissions() {
        return null;
    }

    //Need to revise
    public ISupervisorInfo getSupervisorInfo() {
        return supervisor;
    }


}
