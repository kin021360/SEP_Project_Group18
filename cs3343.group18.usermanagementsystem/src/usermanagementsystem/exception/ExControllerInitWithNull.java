package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */
public class ExControllerInitWithNull extends Exception {
    public ExControllerInitWithNull() {
        super("The controller cannot init with User object 'null'");
    }
}
