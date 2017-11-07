package usermanagementsystem.Menu;

public class Menus {

    boolean done = false;

    public void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|    Welcome !                      |");
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
    }

    //each menu for each page or function

    public void printHomeMenu() {
        System.out.println();
        System.out.println("User Options");
        System.out.println("1) ");
        System.out.println("2) ");
        System.out.println("3) ");
        System.out.println("4) ");//Read My Info
        System.out.println("5) ");//Update My Info
        System.out.println("0) Logout");
        System.out.println();
    }

    public void printAdminHomeMenu() {
        System.out.println();
        System.out.println("Admin Options");
        System.out.println("11) ");//Create User
        System.out.println("12) ");//Read User Info
        System.out.println("13) ");//Update User Info
        System.out.println("14) ");//Delete User
        System.out.println("15) ");
        System.out.println();
    }

}
