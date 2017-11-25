package usermanagementsystem.Menu;

public class Menus {
    public void printHeader(String userName) {
        System.out.println("+-----------------------------------+");
        System.out.println("|    Welcome ! "+String.format("%-21s|",userName));
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
    }
}
