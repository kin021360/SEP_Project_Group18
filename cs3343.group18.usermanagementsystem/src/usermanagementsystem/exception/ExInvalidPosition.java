package usermanagementsystem.exception;

/**
 * The exception for parse value into EnumPosition. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidPosition extends ExInvaildEnumValue {
    public ExInvalidPosition(String position) {
        super("'" + position + "'" + " is invalid position!");
    }
}
