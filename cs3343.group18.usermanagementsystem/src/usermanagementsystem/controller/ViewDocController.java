package usermanagementsystem.controller;

import com.google.gson.*;
import usermanagementsystem.dataaccess.JsonDao;
import usermanagementsystem.datastructure.EnumDepartment;
import usermanagementsystem.datastructure.EnumPermission;
import usermanagementsystem.datastructure_interface.IUserInfo;

/**
 * The Controller class handle viewing Department's document.
 */
class ViewDocController {
    private static ViewDocController instance = new ViewDocController();
    //Set this controller check the Permission level for ViewDocument
    private static EnumPermission requiredPermission = EnumPermission.ViewDocument;
    private JsonObject document;

    /**
     * The constructor init JsonDao and get the document content from "document.json".
     */
    private ViewDocController() {
        JsonDao jsonDao = new JsonDao();
        document = jsonDao.readJsonFile("document.json");
    }

    /**
     * Singleton ViewDocController
     *
     * @return instance ViewDocController
     */
    static ViewDocController getInstance() {
        return instance;
    }

    /**
     * @param department EnumDepartment
     * @return JsonObject for that Department
     */
    private JsonObject getObjectByDepartment(EnumDepartment department) {
        JsonElement temp = document.get(department.toString());
        if (temp != null) {
            return temp.getAsJsonObject();
        }
        return null;
    }

    /**
     * Get User's Department document, if docName with value 'all', return all document content from the User's Department
     *
     * @param user    IUserInfo
     * @param docName docName
     * @return document content
     */
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
