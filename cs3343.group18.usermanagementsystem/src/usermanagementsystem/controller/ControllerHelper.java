package usermanagementsystem.controller;

import java.util.ArrayList;

class ControllerHelper {
    static void initUserChoicesDescriptions(ArrayList<String> descriptionList) {
        descriptionList.add("Print all supported operations.");
        descriptionList.add("Print my details.");
        descriptionList.add("Change my password.");
        descriptionList.add("View my department document.");
    }

    static void initSupervisorChoicesDescriptions(ArrayList<String> descriptionList) {
        descriptionList.add("Check a user who is my subordinate or not.");
    }

    static void initAdminChoicesDescriptions(ArrayList<String> descriptionList) {
        descriptionList.add("Create new user.");
        descriptionList.add("Create new supervisor.");
        descriptionList.add("Remove user or supervisor.");
        descriptionList.add("Upgrade existing user to supervisor.");
        descriptionList.add("Add a new permission to user.");
        descriptionList.add("Remove the permission from user.");
        descriptionList.add("Reset user password.");
        descriptionList.add("Print all normal users details.");
        descriptionList.add("Print all supervisors details.");
        descriptionList.add("Print all people details.");
        descriptionList.add("View a user details.");
        descriptionList.add("View all permissions of a user.");
        descriptionList.add("List all available Departments.");
        descriptionList.add("List all available Permissions.");
        descriptionList.add("List all available Positions.");
    }
}
