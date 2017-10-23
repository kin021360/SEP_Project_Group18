package cs3343.group18.user_management_system.data;

import java.io.BufferedReader;

import com.google.gson.*;

/**
 * Created by Nathan Lam on 18/10/2017.
 */

//http://www.jianshu.com/p/2f7755e3d558

public class UserDao extends JsonDao {

    public void test() {

        Gson gson = new Gson();
        BufferedReader br = readJsonFile("thread_338423.json");
//            JsonObject jsonObject = new JsonParser().parse(br).getAsJsonObject();
        Test t = gson.fromJson(br, Test.class);

    }

    public void testWrite() {
        writeJsonFile("sssssss.txt", "diuxxxxxxxx");
    }
}
