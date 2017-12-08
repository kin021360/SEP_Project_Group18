package usermanagementsystem.exception;

/**
 * The exception for checking string param is or null. Inherits <b>Exception</b>
 */
public class ExIsNullOrEmpty extends Exception {
    public ExIsNullOrEmpty(String paramName) {
        super(paramName + " is null or empty");
    }
}
