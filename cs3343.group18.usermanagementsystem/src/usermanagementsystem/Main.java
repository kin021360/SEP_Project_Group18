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

        String username = "", password = "", newPw = "", confirmNewPw = "", choice = "", input = "";
        int option;
        boolean isAdmin, invalidOption = false;
        Scanner scannerObj = new Scanner(System.in);

        // keep program return to login or menu and other function
        while (true) {
            IController controller = null;
            // before login
            if (!loginObject.getLoginStatus()) {
                System.out.println("User Management System Login");
                System.out.print("Username: ");
                username = scannerObj.next();
                System.out.print("Password: ");
                password = scannerObj.next();

                controller = loginObject.login(username, password);
                if (controller != null) {
                    menu.printHeader(loginObject.getLoggedinUsername());
                    System.out.println(controller.getAllFunctionsDesc());
                    while (scannerObj.hasNext()) {
                        String ch = scannerObj.next();
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
//                            continue;
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
//                            continue;
                        }
//                        System.out.println(controller.getAllFunctionsDesc());
                    }
                } else {
                    System.out.println("Invalid username or password!\n");
                }
            }

            if(choice.matches("^[y|Y]$")){
                //System.out.print("Logout(Y/N)? ");
                //"Logged out!\n"
                loginObject.logoutProcess();
            }
        }

        // // TODO console input interface. No need un-do, re-do command <- very troublesome
        // System.out.println("test main");
        //
        //
        // //sample example to load users based on data.json
        // UserDao userDao = new UserDao();
        //
        // //load User list(Hashtable) without mapping their Supervisor yet
        // Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        // System.out.println(users.get("abc").toString());
        //
        // //load Supervisor list(Hashtable) without mapping their
        // Subordinate(下屬/normal user) yet
        // Hashtable<String, Supervisor> supervisors =
        // userDao.loadSupervisorsWithoutUser();
        // System.out.println(supervisors.get("efg").toString());
        //
        // //Map User and Supervisor
        // userDao.mapUserSupervisor(users, supervisors);
        // System.out.println(users.get("abc").toString());
        //
        // users.get("abc").changePassword("999");
        // supervisors.get("efg").changePassword("777");
        // userDao.updateAndSave(users, supervisors);
    }
}
