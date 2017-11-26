package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;
import usermanagementsystem.exception.ExInvaildEnumValue;
import usermanagementsystem.exception.ExInvalidPermission;

/**
 * Created by nathanlam on 26/10/2017.
 */
public enum EnumPermission {
    @SerializedName("0")
    ViewDocument(0),
    @SerializedName("1")
    ListUsers(1);

    private int permissionId;

    EnumPermission(int id) {
        this.permissionId = id;
    }

    /**
     * @return the id of Permission
     */
    public int getId() {
        return permissionId;
    }

    /**
     * @param eString Permission name or id in string
     * @return EnumPermission
     * @throws ExInvaildEnumValue invalid Enum value
     */
    public static EnumPermission parse(String eString) throws ExInvaildEnumValue {
        try {
            int id = Integer.parseInt(eString);
            return parse(id);
        } catch (Exception e) {
            try {
                return EnumPermission.valueOf(eString);
            } catch (Exception ex) {
                throw new ExInvalidPermission(eString);
            }
        }
    }

    /**
     * @param id Permission int id
     * @return EnumPermission
     * @throws ExInvaildEnumValue invalid Enum value
     */
    public static EnumPermission parse(int id) throws ExInvaildEnumValue {
        EnumPermission[] e = EnumPermission.values();
        if (id > -1 && id < e.length) {
            return e[id];
        }
        throw new ExInvalidPermission("Permission id " + id);
    }

    /**
     * @return list of Permission name and id in string
     */
    public static String listAll() {
        String temp = "Name of Permission       Id\n";
        for (EnumPermission e : EnumPermission.values()) {
            temp += String.format("%18s  ---  %2d\n", e.toString(), e.getId());
        }
        return temp;
    }
}
