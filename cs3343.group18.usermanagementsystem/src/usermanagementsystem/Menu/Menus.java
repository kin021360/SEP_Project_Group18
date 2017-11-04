package usermanagementsystem.Menu;

public class Menus {

    boolean done = false;

    public void printHeader() {
        System.out.println("+-----------------------------------+");
        System.out.println("|    Welcome !                      |");
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
        System.out.println("\n\n Please login: ");

    }

    public void runMenu(){

        while(!done){
            printMenu();
        }
    }

    public void printMenu() {
        System.out.println("1)   ");
        System.out.println("2)   ");
        System.out.println("3)   ");
        System.out.println("4)   ");
        System.out.println("0)   ");
    }

}
