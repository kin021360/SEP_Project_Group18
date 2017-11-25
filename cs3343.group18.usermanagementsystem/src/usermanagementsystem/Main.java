package usermanagementsystem;

import usermanagementsystem.Menu.Menus;
import usermanagementsystem.controller.IController;
import usermanagementsystem.user_login.UserLogin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // login status and get user information
        UserLogin loginObject = UserLogin.getInstance();

        // interface (menu and options)
        Menus menu = new Menus();

        Scanner scannerObj = new Scanner(System.in);

        // keep program return to login or menu and other function
        while (true) {
            // before login
            if (!loginObject.getLoginStatus()) {
                System.out.println("User Management System Login");
                System.out.print("Username (Enter -1 to exit): ");
                String username = scannerObj.next();
                if (username.equals("-1")) break;
                System.out.print("Password: ");
                String password = scannerObj.next();

                IController controller = loginObject.login(username, password);
                if (controller != null) {
                    menu.printHeader(loginObject.getLoggedInUsername());
                    System.out.println("\t-1) --- Logout");
                    System.out.println(controller.getAllFunctionsDesc());
                    while (scannerObj.hasNext()) {
                        String ch = scannerObj.next();
                        if (!ch.equals("-1")) {
                            try {
                                String firstMsg = controller.validateChoiceGetFuncDetail(ch);
                                if (firstMsg.equals("")) {
                                    System.out.println(controller.choiceHandler(ch));
                                } else {
                                    System.out.println(firstMsg);
                                    while (scannerObj.hasNextLine()) {
                                        String line = scannerObj.nextLine();
                                        if (line.equals("")) continue;
                                        String[] values = line.split(" ");
                                        System.out.println(controller.choiceHandler(ch, values));
                                        break;
                                    }
                                }
                            } catch (ArrayIndexOutOfBoundsException arrayEx) {
                                System.out.println("Your input is missing some value. Please try again.");
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
//                        System.out.println(controller.getAllFunctionsDesc());
                        } else {
                            System.out.print("Logout(Y/N)? ");
                            if (scannerObj.next().matches("^[y|Y]$")) {
                                loginObject.logoutProcess();
                                System.out.println("Logged out!\n");
                                break;
                            } else {
                                System.out.println("Invalid input! Cancel logout.\n");
                                System.out.println("\t-1) --- Logout");
                                System.out.println(controller.getAllFunctionsDesc());
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid username or password!\n");
                }
            }
        }
    }
}
