package usermanagementsystem.exception;

/**
 * The exception for parse value into EnumDepartment. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidDepartment extends ExInvaildEnumValue {
    public ExInvalidDepartment(String department) {
        super("'" + department + "'" + " is invalid department!");
    }
}
