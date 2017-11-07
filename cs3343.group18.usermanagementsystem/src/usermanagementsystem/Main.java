package usermanagementsystem;

import usermanagementsystem.Menu.Menus;
import usermanagementsystem.user_login.UserLogin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //login status and get user information
        UserLogin loginObject = UserLogin.getInstance();

        //interface (menu and options)
        Menus menu = new Menus();

        String username = "", password = "", choice = "";
        int option;
        boolean isAdmin, invalidOption = false;
        Scanner scannerObj = new Scanner(System.in);

        //keep program return to login or menu and other function
        while (loginObject.getLoginStatus() == true || loginObject.getLoginStatus() == false) {

            //before login
            if (!loginObject.getLoginStatus()) {
                System.out.print("Username: ");
                username = scannerObj.next();
                System.out.print("Password: ");
                password = scannerObj.next();

                try {
                    if (loginObject.login(username, password)) {
//                        loginObject.setLoginStatus(true);
//                        loginObject.setUsername(username);
                        menu.printHeader();
                    } else {
                        System.out.println("Invalid username or password!\n");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Invalid username or password!\n");
                }
            }

            //after login
            if (loginObject.getLoginStatus()) {
                isAdmin = loginObject.getLoggedInUserInfo().isAdmin();

                menu.printHomeMenu();
                if (isAdmin) {
                    menu.printAdminHomeMenu();
                }

                try {
                    System.out.print("Option: ");
                    option = scannerObj.nextInt();

                    //normal user options
                    switch (option) {
                        case 1:

                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 0:
                            //logout
                            while (!choice.equals("y") && !choice.equals("n")) {
                                System.out.print("Logout(Y/N)? ");
                                choice = scannerObj.next();

                                String logoutMsg = loginObject.logoutProcess(choice.toLowerCase());
                                if (logoutMsg != "") {
                                    System.out.println(logoutMsg);
                                }
                            }
                            choice = "";
                            break;
                        default:
                            invalidOption = true;
                            break;
                    }

                    //admin options
                    if (isAdmin && invalidOption) {
                        switch (option) {
                            case 11:

                                break;
                            case 12:

                                break;
                            case 13:

                                break;
                            case 14:

                                break;
                            case 15:

                                break;
                            default:
                                invalidOption = true;
                                break;
                        }
                    }

                    if (invalidOption) {
                        invalidOption = false;
                        System.out.println("Invalid option!");
                    }

                } catch (InputMismatchException e) {
                    //clear scanner for next option input
                    scannerObj.nextLine();
                    System.out.println("Invalid option!");
                }
            }
        }


//        // TODO console input interface. No need un-do, re-do command <- very troublesome
//        System.out.println("test main");
//
//
//        //sample example to load users based on data.json
//        UserDao userDao = new UserDao();
//
//        //load User list(Hashtable) without mapping their Supervisor yet
//        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
//        System.out.println(users.get("abc").toString());
//
//        //load Supervisor list(Hashtable) without mapping their Subordinate(下屬/normal user) yet
//        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
//        System.out.println(supervisors.get("efg").toString());
//
//        //Map User and Supervisor
//        userDao.mapUserSupervisor(users, supervisors);
//        System.out.println(users.get("abc").toString());
//
//        users.get("abc").changePassword("999");
//        supervisors.get("efg").changePassword("777");
//        userDao.updateAndSave(users, supervisors);

    }
}
