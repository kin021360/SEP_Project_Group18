package usermanagementsystem.dataaccess;

import com.google.gson.*;

import java.io.*;

//https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java

/**
 * The class helps to read and parse the .json file
 * into Google Gson - <b>JsonObject</b> .
 * Also, it support write the .json file from <b>JsonObject</b> .
 */
public class JsonDao {
    protected Gson gson;
    protected JsonParser jsonParser;

    /**
     * Constructs a new instance including some Gson setting.
     * It also affects on sub class.
     */
    public JsonDao() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        jsonParser = new JsonParser();
    }

    /**
     * @param filePath the .json file location
     * @return <b>JsonObject</b>, if error, return <b>null</b>
     */
    public JsonObject readJsonFile(String filePath) {
        try {
            return jsonParser.parse(new BufferedReader(new FileReader(filePath))).getAsJsonObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Writes string into file
     *
     * @param filePath the file location
     * @param string   the file content
     */
    private void writeFile(String filePath, String string) {
        try {
            Writer writer = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            writer.write(string);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Writes JsonObject ( which will convert to string) into file
     *
     * @param filePath   the file location
     * @param jsonObject the JsonObject
     */
    public void writeJsonFile(String filePath, JsonObject jsonObject) {
        String tempStr = gson.toJson(jsonObject);
        writeFile(filePath, tempStr);
    }
}
