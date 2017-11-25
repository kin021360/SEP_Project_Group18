package usermanagementsystem.Menu;

public class Menus {

	boolean done = false;

	public void printHeader() {
		System.out.println("+-----------------------------------+");
		System.out.println("|    Welcome !                      |");
		System.out.println("|                                   |");
		System.out.println("+-----------------------------------+");
	}

	// each menu for each page or function

	public void printHomeMenu() {
		System.out.println();
		System.out.println("User Options");
		System.out.println("1) View Document");
		System.out.println("2) Change My Password");
		System.out.println("0) Logout");
		System.out.println();
	}

	public void printAdminHomeMenu() {
		System.out.println();
		System.out.println("Admin Options");
		System.out.println("11) List User Infomation");
		System.out.println("12) User Permission");
		System.out.println("13) Change User Password");
		System.out.println("14) Create User");
		System.out.println("15) Delete User");
		System.out.println();
	}

	public void printPermissionMenu() {
		System.out.println();
		System.out.println("Permission Options");
		System.out.println("1) Add Permission");
		System.out.println("2) Remove Permission");
		System.out.println("0) Back to main menu");
		System.out.println();
	}

}
