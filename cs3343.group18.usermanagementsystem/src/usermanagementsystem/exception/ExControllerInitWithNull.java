package usermanagementsystem.exception;

/**
 * The exception for controller class initialization. Inherits <b>Exception</b>
 */
public class ExControllerInitWithNull extends Exception {
    public ExControllerInitWithNull() {
        super("The controller cannot init with User object 'null'");
    }
}
