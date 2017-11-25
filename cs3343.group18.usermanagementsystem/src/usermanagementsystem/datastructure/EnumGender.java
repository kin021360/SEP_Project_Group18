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

    public int getId() {
        return genderId;
    }

    public static EnumGender parse(String eString) throws ExInvaildEnumValue {
        try {
            int id = Integer.parseInt(eString);
            return parse(id);
        } catch (Exception e) {
            try {
                return EnumGender.valueOf(eString);
            } catch (Exception ex) {
                throw new ExInvalidGender(eString);
            }
        }
    }

    public static EnumGender parse(int id) throws ExInvaildEnumValue {
        EnumGender[] e = EnumGender.values();
        if (id > -1 && id < e.length) {
            return e[id];
        }
        throw new ExInvalidGender("Gender id " + id);
    }

    public static String listAll() {
        String temp = "Name of Gender       Id\n";
        for (EnumGender e : EnumGender.values()) {
            temp += String.format("%14s  ---  %2d\n", e.toString(), e.getId());
        }
        return temp;
    }
}
