package usermanagementsystem.controller;

import com.google.gson.*;
import usermanagementsystem.dataaccess.JsonDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumPermission;
import usermanagementsystem.datastructure_interface.IUserInfo;

/**
 * Created by Nathan Lam on 18/11/2017.
 */
public class ViewDocController {
    private static ViewDocController instance = new ViewDocController();
    private static EnumPermission requiredPermission = EnumPermission.ViewDocument;
    private JsonDao jsonDao;
    private JsonObject document;

    private ViewDocController() {
        jsonDao = new JsonDao();
        document = jsonDao.readJsonFile("document.json");
    }

    public static ViewDocController getInstance() {
        return instance;
    }

    private JsonObject getObjectByDepartment(EnumDepartment department) {
        JsonElement temp = document.get(department.toString());
        if (temp != null) {
            return temp.getAsJsonObject();
        }
        return null;
    }

    public String viewAllDocument(IUserInfo user) {
        if (user.hasPermission(requiredPermission)) {
            JsonObject docObject = getObjectByDepartment(user.getDepartmentOf());
            if (docObject != null && docObject.keySet().size() > 0) {
                String temp = "\nThe following documents are belonging to your department.\n";
                for (String key : docObject.keySet()) {
                    temp += "Document content --- '" + key + "':\n" + docObject.get(key).getAsString() + "\n\n";
                }
                return temp;
            } else {
                return "Your department does not have any document!";
            }
        } else {
            return "You do not have " + requiredPermission.toString() + " permission";
        }
    }
}
