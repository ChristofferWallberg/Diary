import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static String usersFile = "users.json";

    public static void gsonWriteUserToFile(List<User> users) throws IOException {
        String jsonString;

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        FileWriter jsonFileWrite = new FileWriter(usersFile);
        jsonString = gson.toJson(users);
        jsonFileWrite.write(jsonString);
        jsonFileWrite.close();
    }

    public static User[] gsonReadUserFromFile() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader(usersFile);
            BufferedReader rf = new BufferedReader(fr);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(fr, User[].class);
        } catch (FileNotFoundException e) {
            File emptyUserFile = new File(usersFile);
            return new User[]{};
        }
    }
}
