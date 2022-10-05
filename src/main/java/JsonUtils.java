import com.google.gson.*;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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

    public static User[] gsonReadUserFromFile() {
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
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        Gson gson = builder.create();

        FileWriter jsonFileWrite = new FileWriter(pathDiariesFile.toFile());
        String jsonString = gson.toJson(diaries);
        jsonFileWrite.write(jsonString);
        jsonFileWrite.close();
    }

    public static Diary[] gsonReadDiariesFromFile() {
        try {
            FileReader fr = new FileReader(pathDiariesFile.toFile());
            BufferedReader rf = new BufferedReader(fr);

            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
            builder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
            Gson gson = builder.create();
            return gson.fromJson(fr, Diary[].class);
        } catch (FileNotFoundException e) {
            return new Diary[]{};
        }
    }
}
class LocalDateTimeSerializer implements JsonSerializer< LocalDateTime > {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(localDateTime));
    }
}
class LocalDateTimeDeserializer implements JsonDeserializer < LocalDateTime > {
    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.ENGLISH));
//                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss").withLocale(Locale.ENGLISH));
    }
}
