package cs3343.group18.user_management_system.data;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class JsonDao {

    protected void readJsonFile(String filePath) throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(filePath));
        JsonObject jsonObject=new JsonParser().parse(br).getAsJsonObject();
        System.out.println();
    }

    protected void writeJsonFile(){

    }
}
