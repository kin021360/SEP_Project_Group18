package cs3343.group18.user_management_system.data;

import java.util.Hashtable;

import com.google.gson.*;

/**
 * Created by Nathan Lam on 18/10/2017.
 */

//http://www.jianshu.com/p/2f7755e3d558

//This class handle parsing json object into User object and Supervisor object. Not fully finish yet
//Currently not support write with new users/supervisors into json file. (only read from json)
public class UserDao extends JsonDao {
    private JsonObject jObject;
    private JsonArray userJArray;
    private JsonArray supervisorJArray;
    private JsonObject userSupervisorMapping;

    public UserDao() {
        this("./data.json");
    }

    public UserDao(String customPath) {
        super();
        jObject = readJsonFile(customPath);
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
}
