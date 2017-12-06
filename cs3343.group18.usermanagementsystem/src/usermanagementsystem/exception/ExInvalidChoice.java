package usermanagementsystem.exception;

/**
 * The exception for controller checking invalid user choice. Inherits <b>Exception</b>
 */
public class ExInvalidChoice extends Exception {
    public ExInvalidChoice() {
        super("Invalid Choice!");
    }
}
