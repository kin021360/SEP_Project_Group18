package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidPosition;

/**
 * Created by nathanlam on 24/10/2017.
 */
public enum EnumPosition {
    @SerializedName("0")
    Programmer(0),
    @SerializedName("1")
    Saler(1),
    @SerializedName("2")
    Engineer(2),
    @SerializedName("3")
    QualityAssurance(3),
    @SerializedName("4")
    ProductOwner(4);

    private int positionId;

    private EnumPosition(int id) {
        this.positionId = id;
    }

    public int getId() {
        return positionId;
    }

    public static EnumPosition parse(String eString) throws ExInvaildEnumValue {
        try {
            int id = Integer.parseInt(eString);
            return parse(id);
        } catch (Exception e) {
            try {
                return EnumPosition.valueOf(eString);
            } catch (Exception ex) {
                throw new ExInvalidPosition(eString);
            }
        }
    }

    public static EnumPosition parse(int id) throws ExInvaildEnumValue {
        EnumPosition[] e = EnumPosition.values();
        if (id > -1 && id < e.length) {
            return e[id];
        }
        throw new ExInvalidPosition("Position id " + id);
    }

    public static String listAll() {
        String temp = "Name of Position       Id\n";
        for (EnumPosition e : EnumPosition.values()) {
            temp += String.format("%16s  ---  %2d\n", e.toString(), e.getId());
        }
        return temp;
    }
}
