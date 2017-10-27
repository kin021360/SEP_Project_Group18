package cs3343.group18.user_management_system.data;

import java.io.BufferedReader;
import java.util.Hashtable;

import com.google.gson.*;

/**
 * Created by Nathan Lam on 18/10/2017.
 */

//http://www.jianshu.com/p/2f7755e3d558

public class UserDao extends JsonDao {
    private final String jsonFilePath = "./data.json";
    private JsonObject jObject;
    private JsonArray userJArray;
    private JsonArray supervisorJArray;

    public UserDao() {
        super();
        jObject = readJsonFile(jsonFilePath);
        userJArray = jObject.getAsJsonArray("users");
        supervisorJArray = jObject.getAsJsonArray("supervisors");
    }

    public void test() {
        Gson gson = new Gson();
        JsonObject userJsonObject = readJsonFile("thread_338423.json");


//            JsonObject jsonObject = new JsonParser().parse(br).getAsJsonObject();
        Test t = gson.fromJson(userJsonObject, Test2.class);
        System.out.println();
    }

    public void testWrite() {
        writeJsonFile("sssssss.txt", "diuxxxxxxxx");
    }

    public Hashtable<String, User> loadUsers() {
        Hashtable<String, User> userList = new Hashtable<>();
        for (JsonElement je : userJArray) {
            User tUser = gson.fromJson(je, User.class);
            userList.put(tUser.getUserName(), tUser);
        }
        return userList;
    }

    public Hashtable<String, Supervisor> loadSupervisors() {
        Hashtable<String, Supervisor> superviorList = new Hashtable<>();
        for (JsonElement je : supervisorJArray) {
            Supervisor tSupervisor = gson.fromJson(je, Supervisor.class);
            superviorList.put(tSupervisor.getUserName(), tSupervisor);
        }
        return superviorList;
    }
}
