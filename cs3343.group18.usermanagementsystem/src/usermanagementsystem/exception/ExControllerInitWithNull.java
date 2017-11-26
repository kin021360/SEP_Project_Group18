package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */

/**
 * The exception for controller class initialization. Inherits <b>Exception</b>
 */
public class ExControllerInitWithNull extends Exception {
    public ExControllerInitWithNull() {
        super("The controller cannot init with User object 'null'");
    }
}
