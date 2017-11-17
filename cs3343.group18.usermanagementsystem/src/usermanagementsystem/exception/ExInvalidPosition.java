package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */
public class ExInvalidPosition extends ExInvaildEnumValue {
    public ExInvalidPosition(String position) {
        super("'" + position + "'" + " is invalid position!");
    }
}
