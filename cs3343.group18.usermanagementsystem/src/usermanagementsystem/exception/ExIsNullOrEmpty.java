package usermanagementsystem.exception;

/**
 * Created by Nathan Lam on 18/11/2017.
 */
public class ExIsNullOrEmpty extends Exception {
    public ExIsNullOrEmpty(String paramName) {
        super(paramName + " is null or empty");
    }
}
