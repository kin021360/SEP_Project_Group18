package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */

/**
 * The exception for parse value into EnumGender. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidGender extends ExInvaildEnumValue {
    public ExInvalidGender(String gender) {
        super("'" + gender + "'" + " is invalid gender!");
    }
}
