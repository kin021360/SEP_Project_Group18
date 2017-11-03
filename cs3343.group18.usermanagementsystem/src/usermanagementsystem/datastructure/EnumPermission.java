package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nathanlam on 26/10/2017.
 */
public enum EnumPermission {
    @SerializedName("0")
    ViewDocument(0),
    @SerializedName("1")
    ListUsers(1),
    @SerializedName("2")
    CreateUser(2),
    @SerializedName("3")
    DeleteUser(3),
    @SerializedName("4")
    GrantPermission(4),
    @SerializedName("5")
    ResetPassword(5);

    private int permissionId;

    private EnumPermission(int id) {
        this.permissionId = id;
    }

    public int getPermissionId() {
        return permissionId;
    }
}
