package usermanagementsystem.exception;

/**
 * The base exception for parse value into Enum. Inherits <b>Exception</b>
 */
public class ExInvaildEnumValue extends Exception {
    public ExInvaildEnumValue(String msg) {
        super(msg);
    }
}
