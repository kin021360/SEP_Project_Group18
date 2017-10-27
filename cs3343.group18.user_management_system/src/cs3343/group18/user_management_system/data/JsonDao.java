package cs3343.group18.user_management_system.data;

import com.google.gson.*;

import java.io.*;

//https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java

//This class handle read-write json file. Not fully finish yet
public abstract class JsonDao {
    protected Gson gson;
    protected JsonParser jsonParser;

    public JsonDao() {
        gson = new Gson();
        jsonParser = new JsonParser();
    }

    protected JsonObject readJsonFile(String filePath) {
        try {
            return new JsonParser().parse(new BufferedReader(new FileReader(filePath))).getAsJsonObject();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private void writeFile(String filePath, String string) {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            writer.write(string);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    protected void writeJsonFile(String filePath, String jsonString) {
        writeFile(filePath, jsonString);
    }

    protected void writeJsonFile(String filePath, JsonObject jsonObject) {
        String tempStr = new Gson().toJson(jsonObject);
        writeFile(filePath, tempStr);
    }

    protected void writeJsonFile(String filePath, Object object) {
        String tempStr = new Gson().toJson(object);
        writeFile(filePath, tempStr);
    }
}
