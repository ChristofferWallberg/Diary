import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtils {
    private static final Path pathUserFile = Paths.get("src/main/resources/users.json");
    private static final Path pathDiariesFile = Paths.get("src/main/resources/diaries.json");

    public static void gsonWriteUserToFile(List<User> users) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        FileWriter jsonFileWrite = new FileWriter(pathUserFile.toFile());
        String jsonString = gson.toJson(users);
        jsonFileWrite.write(jsonString);
        jsonFileWrite.close();
    }

    public static User[] gsonReadUserFromFile() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader(pathUserFile.toFile());
            BufferedReader rf = new BufferedReader(fr);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(fr, User[].class);
        } catch (FileNotFoundException e) {
            return new User[]{};
        }
    }
    public static void gsonWriteDiaryToFile(List<Diary> diaries ) throws IOException {

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        FileWriter jsonFileWrite = new FileWriter(pathDiariesFile.toFile());
        String jsonString = gson.toJson(diaries);
        jsonFileWrite.write(jsonString);
        jsonFileWrite.close();
    }

    public static Diary[] gsonReadDiariesFromFile() throws FileNotFoundException {
        try {
            FileReader fr = new FileReader(pathDiariesFile.toFile());
            BufferedReader rf = new BufferedReader(fr);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(fr, Diary[].class);
        } catch (FileNotFoundException e) {
            return new Diary[]{};
        }
    }
}
