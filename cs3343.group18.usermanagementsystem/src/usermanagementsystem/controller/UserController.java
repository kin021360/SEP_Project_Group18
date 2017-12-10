package usermanagementsystem.controller;

import usermanagementsystem.datastructure.*;
import usermanagementsystem.exception.ExControllerInitWithNull;
import usermanagementsystem.exception.ExInvalidChoice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 * The base Controller class for normal user.
 */
public class UserController implements IController {
    protected User currentUser;
    private ViewDocController viewDocController;
    private static UserController instance = new UserController();
    protected ArrayList<String> funcChoicesDescriptions;

    /**
     * The constructor init the ViewDocController ref and choices description list.
     */
    protected UserController() {
        currentUser = null;
        viewDocController = ViewDocController.getInstance();
        funcChoicesDescriptions = new ArrayList<>();
        ControllerHelper.initUserChoicesDescriptions(funcChoicesDescriptions);
    }

    /**
     * Singleton UserController
     *
     * @param user User
     * @return instance UserController
     * @throws ExControllerInitWithNull the input param cannot be null
     */
    public static UserController getInstance(User user) throws ExControllerInitWithNull {
        if (user == null) throw new ExControllerInitWithNull();
        instance.currentUser = user;
        return instance;
    }

    private String getMyDetails() {
        return ControllerHelper.userDetailsHeader + "\n" + currentUser.toString();
    }

    /**
     * Change current user's password
     *
     * @param oldPassword        old password
     * @param newPassword        new password
     * @param confirmNewPassword re-enter password
     * @return change password result message
     */
    private String changeMyPassword(String oldPassword, String newPassword, String confirmNewPassword) {
        if (currentUser.checkPassword(oldPassword)) {
            if (newPassword.equals(confirmNewPassword)) {
                currentUser.changePassword(newPassword);
                return "Password changed!";
            }
            return "New password and confirm new password are different!";
        }
        return "Old password is incorrect!";
    }

    /**
     * @param optionalDocName (with value 'all' the get all document
     * @return document content
     */
    public String getDepartmentDoc(String optionalDocName) {
        return viewDocController.getDepartmentDoc(currentUser, optionalDocName);
    }


    private String requestAnnualLeave(String dayOfAnnualLeave, String startDateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = new Date(startDate.getTime() + ((Long.parseLong(dayOfAnnualLeave) - 1) * 24 * 60 * 60) * 1000);
            String currDateStr = sdf.format(new Date());
            Date currDate = sdf.parse(currDateStr);
            String currYear = sdfy.format(currDate);
            String startYear = sdfy.format(startDate);

            HashSet<String> annualLeaveInfos = currentUser.getAnnualLeaveInfos();
            for (String annualLeaveInfo : annualLeaveInfos) {
                String[] infoArray = annualLeaveInfo.split(" ");
                Date checkStartDate = new Date(Long.parseLong(infoArray[1]));
                Date checkEndDate = new Date(Long.parseLong(infoArray[2]));
                if (startDate.getTime() >= checkStartDate.getTime() && startDate.getTime() <= checkEndDate.getTime()) {
                    return "Start date is overlap with another annual leave!";
                }
            }
            if (Integer.parseInt(dayOfAnnualLeave) > currentUser.getAnnualLeave()) {
                return "Exceeded the quota! You only have " + currentUser.getAnnualLeave() + " day(s) of annual leave!";
            } else if (Integer.parseInt(dayOfAnnualLeave) < 1) {
                return "Invalid day(s) of annual leave!";
            } else if (startDateStr.length() != 10) {
                return "Invalid start date format!";
            } else if (startDate.getTime() < currDate.getTime()) {
                return "Start date earlier than current date!";
            } else if (Integer.parseInt(startYear) > Integer.parseInt(currYear)) {
                return "The year should be current year only!!";
            }
            AnnualLeaveInfo annualLeaveInfo = new AnnualLeaveInfo(Integer.parseInt(dayOfAnnualLeave), startDate, endDate);
            currentUser.addAnnualLeaveInfo(annualLeaveInfo, annualLeaveInfo.toString());
            return "Annual leave(s) requested!";
        } catch (NumberFormatException e) {
            return "Invalid day(s) of annual leave!";
        } catch (ParseException e) {

            return "Invalid start date";
        }
    }

    private String getMyAnnualLeaveInfo() {
        return "Annual Leave Information\n" + currentUser.showAllAnnualLeaveInfos();
    }

    /**
     * Validate the choice and get choice detail
     *
     * @param choice string number, 0 based
     * @return string description for the choice, can be empty string
     * @throws ExInvalidChoice no existing choice in controller
     */
    @Override
    public String validateChoiceGetFuncDetail(String choice) throws ExInvalidChoice {
        switch (choice) {
            case "1":
                return "";
            case "2":
                return "Please enter your 'old-password', 'new-password' and 'confirm-new-password':";
            case "3":
                return "Please enter the document name or enter 'all' to show all documents:";
            case "4":
                return "Current day(s) of annual leave: " + currentUser.getAnnualLeave() + "\nPlease enter 'day(s) of annual leave', 'start date(dd-mm-yyyy)':";
            case "5":
                return "";
        }
        throw new ExInvalidChoice();
    }

    /**
     * Involve the action based on the choice
     *
     * @param choice string number, 0 based
     * @param values for the choice, in string array / string array param
     * @return string message
     * @throws Exception include the message that the action cannot be executed
     */
    @Override
    public String choiceHandler(String choice, String... values) throws Exception {
        switch (choice) {
            case "1":
                return getMyDetails();
            case "2":
                return changeMyPassword(values[0], values[1], values[2]);
            case "3":
                return getDepartmentDoc(values.length == 0 ? null : values[0]);
            case "4":
                return requestAnnualLeave(values[0], values[1]);
            case "5":
                return getMyAnnualLeaveInfo();
        }
        throw new ExInvalidChoice();
    }

    /**
     * @return all supported choices function description
     */
    @Override
    public String getAllFunctionsDesc() {
        String temp = "";
        for (int i = 1; i < funcChoicesDescriptions.size(); i++) {
            temp += "\t " + i + ") --- " + funcChoicesDescriptions.get(i) + "\n";
        }
        return temp;
    }

    /**
     * Clear current user session in controller
     */
    public void clear() {
        currentUser = null;
    }
}
