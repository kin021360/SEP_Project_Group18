package usermanagementsystem.exception;

/**
 * Created by Nathan on 17/11/2017.
 */
public class ExInvalidGender extends ExInvaildEnumValue {
    public ExInvalidGender(String gender) {
        super("'" + gender + "'" + " is invalid gender!");
    }
}
