package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidGender;

/**
 * Created by Nathan on 27/10/2017.
 */
public enum EnumGender {
    @SerializedName("0")
    Male(0),
    @SerializedName("1")
    Female(1);

    private int genderId;

    private EnumGender(int id) {
        this.genderId = id;
    }

    public int getGenderIdId() {
        return genderId;
    }

    public static EnumGender parse(String eString) throws ExInvaildEnumValue {
        try {
            return EnumGender.valueOf(eString);
        } catch (Exception e) {
            throw new ExInvalidGender(eString);
        }
    }
}
