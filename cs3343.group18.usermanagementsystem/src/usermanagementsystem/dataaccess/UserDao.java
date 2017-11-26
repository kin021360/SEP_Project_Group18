package usermanagementsystem.dataaccess;

import java.util.Hashtable;

import com.google.gson.*;

import usermanagementsystem.datastructure.*;

/**
 * Created by Nathan Lam on 18/10/2017.
 */

//http://www.jianshu.com/p/2f7755e3d558

/**
 * The class helps to parse the .json file. Inherits <b>JsonDao</b>
 * into <b>User Hashtable list</b> and <b>Supervisor Hashtable list</b>
 */
public class UserDao extends JsonDao {
    private static final String defJsonPath = "./data.json";
    private String currentJsonPath;
    private JsonObject jObject;
    private JsonArray userJArray;
    private JsonArray supervisorJArray;
    private JsonObject userSupervisorMapping;

    /**
     * Default constructor will init with <b>data.json</b> in the project
     */
    public UserDao() {
        this(defJsonPath);
    }

    /**
     * The constructor will init with .json file.
     * If .json file is invalid or not found, it will throw <b>RuntimeException</b>
     *
     * @param customPath the .json file location
     */
    public UserDao(String customPath) {
        super();
        currentJsonPath = customPath;
        jObject = readJsonFile(currentJsonPath);
        if (jObject == null) throw new RuntimeException("Cannot load the json file.");
        userJArray = jObject.getAsJsonArray("users");
        supervisorJArray = jObject.getAsJsonArray("supervisors");
        userSupervisorMapping = jObject.getAsJsonObject("userSupervisorMapping");
    }

    /**
     * Parse json data into <b>User</b> object and create Hashtable
     *
     * @return <b>User Hashtable list</b>
     */
    public Hashtable<String, User> loadUsersWithoutSupervisor() {
        Hashtable<String, User> userList = new Hashtable<>();
        for (JsonElement je : userJArray) {
            User tUser = gson.fromJson(je, User.class);
            userList.put(tUser.getUserName(), tUser);
        }
        return userList;
    }

    /**
     * Parse json data into <b>Supervisor</b> object and create Hashtable
     *
     * @return <b>Supervisor Hashtable list</b>
     */
    public Hashtable<String, Supervisor> loadSupervisorsWithoutUser() {
        Hashtable<String, Supervisor> supervisorList = new Hashtable<>();
        for (JsonElement je : supervisorJArray) {
            Supervisor tSupervisor = gson.fromJson(je, Supervisor.class);
            supervisorList.put(tSupervisor.getUserName(), tSupervisor);
        }
        return supervisorList;
    }

    /**
     * Map User and Supervisor with Subordinate relationship from json data
     *
     * @param users       User Hashtable list
     * @param supervisors Supervisor Hashtable list
     */
    public void mapUserSupervisor(Hashtable<String, User> users, Hashtable<String, Supervisor> supervisors) {
        for (String key : userSupervisorMapping.keySet()) {
            User u = users.get(key);
            Supervisor s = supervisors.get(userSupervisorMapping.get(key).getAsString());
            u.assignSupervisor(s);
            s.addSubordinate(u);
        }
    }

    /**
     * Based on this two Hashtable and write data back into json file
     *
     * @param users       User Hashtable list
     * @param supervisors Supervisor Hashtable list
     */
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
