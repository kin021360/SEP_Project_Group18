package usermanagementsystem.test;

import com.google.gson.*;
import junit.framework.TestCase;

import org.junit.Test;

import usermanagementsystem.dataaccess.*;
import usermanagementsystem.datastructure.*;

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

}
