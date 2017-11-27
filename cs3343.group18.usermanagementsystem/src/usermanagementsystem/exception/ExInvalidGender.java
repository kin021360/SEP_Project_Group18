package usermanagementsystem.exception;

/**
 * The exception for parse value into EnumGender. Inherits <b>ExInvaildEnumValue</b>
 */
public class ExInvalidGender extends ExInvaildEnumValue {
    public ExInvalidGender(String gender) {
        super("'" + gender + "'" + " is invalid gender!");
    }
}
