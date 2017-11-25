package usermanagementsystem.Menu;

public class Menus {
    public void printHeader(String userName) {
        System.out.println("+-----------------------------------+");
        System.out.println("|                                   |");
        System.out.println("|           Welcome ! "+String.format("%-14s|",userName));
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
    }
}
