package cs3343.group18.user_management_system.data;

/**
 * Created by nathanlam on 24/10/2017.
 */
public enum EnumPosition {
    Programmer(0),
    Saler(1);

    private int positionId;

    private EnumPosition(int id) {
        this.positionId = id;
    }

    public int getPositionId() {
        return positionId;
    }
}
