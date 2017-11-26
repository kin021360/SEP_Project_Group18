package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidDepartment;

/**
 * Created by Nathan Lam on 3/11/2017.
 */

/**
 * The Enum of Department
 */
public enum EnumDepartment {
    @SerializedName("0")
    Technology(0),
    @SerializedName("1")
    HumanResource(1),
    @SerializedName("2")
    Finance(2),
    @SerializedName("3")
    Marketing(3),
    @SerializedName("4")
    Sales(4);

    private int departmentId;

    EnumDepartment(int id) {
        this.departmentId = id;
    }

    /**
     * @return the id of Department
     */
    public int getId() {
        return departmentId;
    }

    /**
     * @param eString Department name or id in string
     * @return EnumDepartment
     * @throws ExInvaildEnumValue invalid Enum value
     */
    public static EnumDepartment parse(String eString) throws ExInvaildEnumValue {
        try {
            int id = Integer.parseInt(eString);
            return parse(id);
        } catch (Exception e) {
            try {
                return EnumDepartment.valueOf(eString);
            } catch (Exception ex) {
                throw new ExInvalidDepartment(eString);
            }
        }
    }

    /**
     * @param id Department int id
     * @return EnumDepartment
     * @throws ExInvaildEnumValue invalid Enum value
     */
    public static EnumDepartment parse(int id) throws ExInvaildEnumValue {
        EnumDepartment[] e = EnumDepartment.values();
        if (id > -1 && id < e.length) {
            return e[id];
        }
        throw new ExInvalidDepartment("Department id " + id);
    }

    /**
     * @return list of Department name and id in string
     */
    public static String listAll() {
        String temp = "Name of Department       Id\n";
        for (EnumDepartment e : EnumDepartment.values()) {
            temp += String.format("%18s  ---  %2d\n", e.toString(), e.getId());
        }
        return temp;
    }
}
