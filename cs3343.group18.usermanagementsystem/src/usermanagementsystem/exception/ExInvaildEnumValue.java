package usermanagementsystem.exception;

/**
 * Created by Nathan Lam on 17/11/2017.
 */

/**
 * The base exception for parse value into Enum. Inherits <b>Exception</b>
 */
public class ExInvaildEnumValue extends Exception {
    public ExInvaildEnumValue(String msg) {
        super(msg);
    }
}
