package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */

/**
 * The exception for parse value into EnumDepartment. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidDepartment extends ExInvaildEnumValue {
    public ExInvalidDepartment(String department) {
        super("'" + department + "'" + " is invalid department!");
    }
}
