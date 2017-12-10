package usermanagementsystem.test;

import com.google.gson.*;

import org.junit.Test;

import static org.junit.Assert.*;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;

/**
 * Created by Nathan Lam on 7/11/2017.
 */
public class TestDataAccess {

    @Test
    public void testJsonDao1() {
        JsonParser jParser = new JsonParser();
        String originalUserJsonStr = "{\"users\":[{\"userName\":\"testUser\",\"password\":\"111\",\"gender\":\"0\",\"position\":\"0\",\"permissions\":[\"0\"],\"staffId\":111,\"email\":\"testUser@testUser.com\",\"departmentOf\":\"0\",\"isAdmin\":false}],\"supervisors\":[{\"userName\":\"testSupervisor\",\"password\":\"222\",\"gender\":\"0\",\"position\":\"0\",\"permissions\":[\"0\"],\"staffId\":222,\"email\":\"testSupervisor@testSupervisor.com\",\"departmentOf\":\"0\",\"isAdmin\":false}],\"userSupervisorMapping\":{\"testUser\":\"testSupervisor\"}}";
        JsonDao jsonDao = new JsonDao();
        JsonObject jObject = jsonDao.readJsonFile("dataTest.json");

        //assert both result in JsonElement object level
        assertEquals(jParser.parse(originalUserJsonStr), jObject);
    }

    @Test
    public void testJsonDao2() {
        JsonDao jsonDao = new JsonDao();
        JsonObject jObject = jsonDao.readJsonFile("faefafaefeafae");

        assertNull(jObject);
    }

    @Test
    public void testJsonDao3() {
        JsonParser jParser = new JsonParser();
        String originalUserJsonStr = "{\"users\":[{\"userName\":\"testUser\",\"password\":\"111\",\"gender\":\"0\",\"position\":\"0\",\"permissions\":[\"0\"],\"staffId\":111,\"email\":\"testUser@testUser.com\",\"departmentOf\":\"0\",\"isAdmin\":false}],\"supervisors\":[{\"userName\":\"testSupervisor\",\"password\":\"222\",\"gender\":\"0\",\"position\":\"0\",\"permissions\":[\"0\"],\"staffId\":222,\"email\":\"testSupervisor@testSupervisor.com\",\"departmentOf\":\"0\",\"isAdmin\":false}],\"userSupervisorMapping\":{\"testUser\":\"testSupervisor\"}}";
        JsonDao jsonDao = new JsonDao();
        JsonObject jObject = jParser.parse(originalUserJsonStr).getAsJsonObject();
        jsonDao.writeJsonFile("dataTestWrite.json",jObject);

        //assert both result in JsonElement object level
        assertEquals(jObject, jsonDao.readJsonFile("dataTestWrite.json"));
    }

    @Test
    public void testParseUserFromJsonFile() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        JsonParser jParser = new JsonParser();
        String originalUserJsonStr = "{\"userName\": \"testUser\",\"password\": \"111\",\"gender\": \"0\",\"position\": \"0\",\"permissions\": [ \"0\"],\"staffId\": 111,\"email\": \"testUser@testUser.com\",\"departmentOf\": \"0\",\"isAdmin\": false,\"loginFailTime\":0,\"suspensionTimeStamp\":0,\"annualLeave\":0}";
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
        String originalSupervisorJsonStr = "{\"userName\": \"testSupervisor\",\"password\": \"222\",\"gender\": \"0\",\"position\": \"0\",\"permissions\": [\"0\"],\"staffId\": 222,\"email\": \"testSupervisor@testSupervisor.com\", \"departmentOf\": \"0\",\"isAdmin\": false,\"loginFailTime\":0,\"suspensionTimeStamp\":0,\"annualLeave\":0}";
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

        assertTrue(users.get("abc").getSupervisorInfo().equals(supervisors.get("efg")));
        assertTrue(supervisors.get("efg").isMySubordinate(users.get("abc").getUserName()));
    }

    @Test
    public void testMapUserSupervisor() {
        UserDao userDao = new UserDao("dataTest.json");
        Hashtable<String, User> users = userDao.loadUsersWithoutSupervisor();
        Hashtable<String, Supervisor> supervisors = userDao.loadSupervisorsWithoutUser();
        userDao.mapUserSupervisor(users, supervisors);

        assertTrue(users.get("testUser").getSupervisorInfo().equals(supervisors.get("testSupervisor")));
        assertTrue(supervisors.get("testSupervisor").isMySubordinate(users.get("testUser").getUserName()));
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

        assertTrue(jo.get("users").getAsJsonArray().get(0).getAsJsonObject().get("password").getAsString().equals(nPassword));
        assertTrue(jo.get("supervisors").getAsJsonArray().get(0).getAsJsonObject().get("password").getAsString().equals(nPassword));
    }

    @Test(expected = RuntimeException.class)
    public void testJsonFileNotFound() throws RuntimeException {
        UserDao userDao = new UserDao("xlihhhoix.json");
    }
}
