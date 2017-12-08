package usermanagementsystem;

import usermanagementsystem.controller.IController;
import usermanagementsystem.user_login.UserLogin;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void printHeader(String userName) {
        System.out.println("+-----------------------------------+");
        System.out.println("|                                   |");
        System.out.println("|           Welcome ! " + String.format("%-14s|", userName));
        System.out.println("|                                   |");
        System.out.println("+-----------------------------------+");
    }

    public static void main(String[] args) throws IOException {
        // login status and get user information
        UserLogin loginObject = UserLogin.getInstance();

        Scanner scannerObj = new Scanner(System.in);

        // keep program return to login or menu and other function
        while (true) {
            // before login
            if (!loginObject.getLoginStatus()) {
                System.out.println("Welcome To User Management System!");
                System.out.println("Please enter your choice:");
                System.out.println("\t0) --- Login");
                System.out.println("\t1) --- Exit");
                String temp = scannerObj.next();
                if (temp.equals("1")) break;
                if (!temp.equals("0")) continue;

                System.out.print("Username: ");
                String username = scannerObj.next();
                System.out.print("Password: ");
                String password = scannerObj.next();

                IController controller = loginObject.login(username, password);
                if (controller != null) {
                    printHeader(loginObject.getLoggedInUsername());
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
                            } catch (NumberFormatException numEx) {
                                System.out.println("Invalid choice!");
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            System.out.println("\nPlease press Enter to continue...");
                            System.in.read();
                            System.out.println("\t-1) --- Logout");
                            System.out.println(controller.getAllFunctionsDesc());
                        } else {
                            System.out.print("Logout(Y)? ");
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
