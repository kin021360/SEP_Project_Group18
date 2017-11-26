package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */

/**
 * The exception for parse value into EnumPosition. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidPosition extends ExInvaildEnumValue {
    public ExInvalidPosition(String position) {
        super("'" + position + "'" + " is invalid position!");
    }
}
