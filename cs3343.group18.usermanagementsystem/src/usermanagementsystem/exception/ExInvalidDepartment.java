package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */
public class ExInvalidDepartment extends Exception {
    public ExInvalidDepartment(String department) {
        super("'" + department + "'" + " is invalid department!");
    }
}
