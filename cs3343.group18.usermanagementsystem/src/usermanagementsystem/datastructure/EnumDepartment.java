package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nathan Lam on 3/11/2017.
 */
public enum EnumDepartment {
    @SerializedName("0")
    Technology(0),
    @SerializedName("1")
    HumanResource(1),
    @SerializedName("2")
    Finance(2);

    private int departmentId;

    private EnumDepartment(int id) {
        this.departmentId = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public EnumDepartment parse(String eString) {
        try {
            return EnumDepartment.valueOf(eString);
        } catch (Exception e) {
            return null;
        }
    }
}
