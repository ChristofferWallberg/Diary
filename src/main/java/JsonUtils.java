import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class JsonUtils {
    private static String filename = "users.json";

    public static void gsonWriteUserToFile(List<User> users) throws IOException {
        String jsonString;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        FileWriter jsonFileWrite = new FileWriter(filename);
        jsonString = gson.toJson(users);
        jsonFileWrite.write(jsonString);
        jsonFileWrite.close();
    }

    public static User[] gsonReadUserFromFile() throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        BufferedReader rf = new BufferedReader(fr);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
//        gson.fromJson(rf, User.class);
         User[] users = gson.fromJson(fr, User[].class);
         return users;
    }
}
