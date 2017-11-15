package usermanagementsystem.datastructure;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nathanlam on 24/10/2017.
 */
public enum EnumPosition {
    @SerializedName("0")
    Programmer(0),
    @SerializedName("1")
    Saler(1);

    private int positionId;

    private EnumPosition(int id) {
        this.positionId = id;
    }

    public int getPositionId() {
        return positionId;
    }

    public EnumPosition parse(String eString) {
        try {
            return EnumPosition.valueOf(eString);
        } catch (Exception e) {
            return null;
        }
    }
}
