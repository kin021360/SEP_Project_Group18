package usermanagementsystem.exception;

/**
 * Created by Nathan Lam on 25/11/2017.
 */

/**
 * The exception for controller checking invalid user choice. Inherits <b>Exception</b>
 */
public class ExInvalidChoice extends Exception {
    public ExInvalidChoice() {
        super("Invalid Choice!");
    }
}
