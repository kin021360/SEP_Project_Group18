package usermanagementsystem.dataaccess;

import java.util.Hashtable;

import com.google.gson.*;

import usermanagementsystem.datastructure.*;

/**
 * Created by Nathan Lam on 18/10/2017.
 */

//http://www.jianshu.com/p/2f7755e3d558

//This class handle parsing json object into User object and Supervisor object. Not fully finish yet
public class UserDao extends JsonDao {
    private static final String defJsonPath = "./data.json";
    private String currentJsonPath;
    private JsonObject jObject;
    private JsonArray userJArray;
    private JsonArray supervisorJArray;
    private JsonObject userSupervisorMapping;

    public UserDao() {
        this(defJsonPath);
    }

    public UserDao(String customPath) {
        super();
        currentJsonPath = customPath;
        jObject = readJsonFile(currentJsonPath).getAsJsonObject();
        userJArray = jObject.getAsJsonArray("users");
        supervisorJArray = jObject.getAsJsonArray("supervisors");
        userSupervisorMapping = jObject.getAsJsonObject("userSupervisorMapping");
    }

    public Hashtable<String, User> loadUsersWithoutSupervisor() {
        Hashtable<String, User> userList = new Hashtable<>();
        for (JsonElement je : userJArray) {
            User tUser = gson.fromJson(je, User.class);
            userList.put(tUser.getUserName(), tUser);
        }
        return userList;
    }

    public Hashtable<String, Supervisor> loadSupervisorsWithoutUser() {
        Hashtable<String, Supervisor> supervisorList = new Hashtable<>();
        for (JsonElement je : supervisorJArray) {
            Supervisor tSupervisor = gson.fromJson(je, Supervisor.class);
            supervisorList.put(tSupervisor.getUserName(), tSupervisor);
        }
        return supervisorList;
    }

    public void mapUserSupervisor(Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) {
        for (String key : userSupervisorMapping.keySet()) {
            User u = users.get(key);
            Supervisor s = supervisors.get(userSupervisorMapping.get(key).getAsString());
            u.assignSupervisor(s);
            s.addSubordinate(u);
        }
    }

    public void updateAndSave(Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) {
        userJArray = jsonParser.parse(gson.toJson(users.values())).getAsJsonArray();
        supervisorJArray = jsonParser.parse(gson.toJson(supervisors.values())).getAsJsonArray();
        userSupervisorMapping = new JsonObject();
        for (User u : users.values()) {
            if (u.getSupervisorInfo() != null) {
                userSupervisorMapping.addProperty(u.getUserName(), u.getSupervisorInfo().getUserName());
            }
        }
        jObject.add("users", userJArray);
        jObject.add("supervisors", supervisorJArray);
        jObject.add("userSupervisorMapping", userSupervisorMapping);
        writeJsonFile(currentJsonPath, jObject);
    }
}
