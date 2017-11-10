package usermanagementsystem.test;

import com.google.gson.*;
import junit.framework.TestCase;

import org.junit.Test;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

/**
 * Created by Nathan Lam on 7/11/2017.
 */
public class TestDataAccess extends TestCase {

    @Test
    public void testParseUserFromJsonFile() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        JsonParser jParser = new JsonParser();
        String originalUserJsonStr = "{\"userName\": \"testUser\",\"password\": \"111\",\"gender\": \"0\",\"position\": \"0\",\"permissions\": [ \"0\"],\"staffId\": 111,\"email\": \"testUser@testUser.com\",\"departmentOf\": \"0\",\"isAdmin\": false}";
        UserDao userDao = new UserDao("dataTest.json");
        User userFromDao = userDao.loadUsersWithoutSupervisor().get("testUser");
        //serialize userFromDao to json string
        String userFromDaoJsonStr = gson.toJson(userFromDao);
        //assert both result in JsonElement object level
        assertEquals(jParser.parse(originalUserJsonStr), jParser.parse(userFromDaoJsonStr));
    }

    @Test
    public void testParseSupervisorFromJsonFile() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        JsonParser jParser = new JsonParser();
        String originalSupervisorJsonStr = "{\"userName\": \"testSupervisor\",\"password\": \"222\",\"gender\": \"0\",\"position\": \"0\",\"permissions\": [\"0\"],\"staffId\": 222,\"email\": \"testSupervisor@testSupervisor.com\", \"departmentOf\": \"0\",\"isAdmin\": false}";
        UserDao userDao = new UserDao("dataTest.json");
        Supervisor supervisorFromDao = userDao.loadSupervisorsWithoutUser().get("testSupervisor");
        //serialize supervisorFromDao to json string
        String supervisorFromDaoStr = gson.toJson(supervisorFromDao);
        //assert both result in JsonElement object level
        assertEquals(jParser.parse(originalSupervisorJsonStr), jParser.parse(supervisorFromDaoStr));
    }

    @Test
    public void testDefaultUserDao() {
        UserDao userDao = new UserDao();
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        userDao.mapUserSupervisor(users, supervisors);
        boolean result = users.get("abc").getSupervisorInfo().equals(supervisors.get("efg")) && supervisors.get("efg").isMySubordinate(users.get("abc"));
        assertEquals(true, result);
    }

    @Test
    public void testMapUserSupervisor() {
        UserDao userDao = new UserDao("dataTest.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        userDao.mapUserSupervisor(users, supervisors);
        boolean result = users.get("testUser").getSupervisorInfo().equals(supervisors.get("testSupervisor")) && supervisors.get("testSupervisor").isMySubordinate(users.get("testUser"));
        assertEquals(true, result);
    }

    @Test
    public void testUpdateAndSave() throws Exception {
        UserDao userDao = new UserDao("dataTestWrite.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        userDao.mapUserSupervisor(users, supervisors);
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String nPassword = df.format(Calendar.getInstance().getTime());
        users.get("testUser").changePassword(nPassword);
        supervisors.get("testSupervisor").changePassword(nPassword);
        userDao.updateAndSave(users, supervisors);
        JsonParser jParser = new JsonParser();
        JsonObject jo = jParser.parse(new FileReader("dataTestWrite.json")).getAsJsonObject();
        boolean result = jo.get("users").getAsJsonArray().get(0).getAsJsonObject().get("password").getAsString().equals(nPassword) &&
                jo.get("supervisors").getAsJsonArray().get(0).getAsJsonObject().get("password").getAsString().equals(nPassword);
        assertEquals(true, result);
    }

    @Test
    public void testJsonFileNotFound() throws Exception {
        UserDao userDao = null;
        try {
            userDao = new UserDao("xlihhhoix.json");
        } catch (Exception e) {

        }
        assertEquals(null, userDao);
    }
}
