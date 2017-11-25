package usermanagementsystem.controller;

import com.google.gson.*;
import usermanagementsystem.dataaccess.JsonDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumPermission;
import usermanagementsystem.datastructure_interface.IUserInfo;

/**
 * Created by Nathan Lam on 18/11/2017.
 */
class ViewDocController {
    private static ViewDocController instance = new ViewDocController();
    private static EnumPermission requiredPermission = EnumPermission.ViewDocument;
    private JsonDao jsonDao;
    private JsonObject document;

    private ViewDocController() {
        jsonDao = new JsonDao();
        document = jsonDao.readJsonFile("document.json");
    }

    static ViewDocController getInstance() {
        return instance;
    }

    private JsonObject getObjectByDepartment(EnumDepartment department) {
        JsonElement temp = document.get(department.toString());
        if (temp != null) {
            return temp.getAsJsonObject();
        }
        return null;
    }

    String getDepartmentDoc(IUserInfo user, String docName) {
        if (user.hasPermission(requiredPermission)) {
            JsonObject docObject = getObjectByDepartment(user.getDepartmentOf());
            if (docObject != null && docObject.keySet().size() > 0) {
                if (docName == null || docName.equals("all")) {
                    String temp = "\nThe following documents are belonging to your department.\n";
                    for (String key : docObject.keySet()) {
                        temp += "Document content --- '" + key + "':\n" + docObject.get(key).getAsString() + "\n\n";
                    }
                    return temp;
                } else if (docObject.has(docName)) {
                    return "Document content --- '" + docName + "':\n" + docObject.get(docName).getAsString() + "\n\n";
                }
                return "Document '" + docName + "' not found in your department!";
            } else {
                return "Your department does not have any document!";
            }
        } else {
            return "You do not have " + requiredPermission.toString() + " permission";
        }
    }
}
