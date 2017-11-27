package usermanagementsystem.exception;

/**
 * The exception for parse value into EnumPermission. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidPermission extends ExInvaildEnumValue {
    public ExInvalidPermission(String permission) {
        super("'" + permission + "'" + " is invalid permission!");
    }
}
