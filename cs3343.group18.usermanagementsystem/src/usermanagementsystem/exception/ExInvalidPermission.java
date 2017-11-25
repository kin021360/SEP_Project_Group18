package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */
public class ExInvalidPermission extends ExInvaildEnumValue {
    public ExInvalidPermission(String permission) {
        super("'" + permission + "'" + " is invalid permission!");
    }
}
