package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nathanlam on 26/10/2017.
 */
public enum EnumPermission {
    @SerializedName("0")
    ViewDocument(0),
    @SerializedName("1")
    ListUsers(1);

    private int permissionId;

    private EnumPermission(int id) {
        this.permissionId = id;
    }

    public int getPermissionId() {
        return permissionId;
    }
}
