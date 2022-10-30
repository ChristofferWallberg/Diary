import java.io.IOException;
import java.util.List;

public class User {
    private final String username;
    private static User CURRENTUSER;

    public User(String username) {
        this.username = username;
    }

    public static void getLoggedInUser() {
        System.out.println("Inloggad användare: " + User.getCURRENTUSER().getUsername());
    }

    public String getUsername() {
        return username;
    }

    public static User getCURRENTUSER() {
        return CURRENTUSER;
    }


    public static void setCURRENTUSER(User CURRENTUSER) {
        User.CURRENTUSER = CURRENTUSER;
    }

    @Override
    public String toString() {
        return username;
    }

    /**
     * Print all users in the provided list of users.
     * @param users
     */
    public static void printAllUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }
    /**
     * Checks if username exists in the list of users and returns true if the user exists.
     * @param users
     * @param user
     * @return
     */
    public static boolean checkIfUserExist(List<User> users, String user) {
        boolean userExists = false;
        for (User newUser : users) {
            if (newUser.getUsername().equalsIgnoreCase(user)) {
                userExists = true;
                System.out.println("Användaren finns redan.");
                break;
            }
        }
        return userExists;
    }
    /**
     * If the boolean provided is false (username does not exist), creates user and adding it to the list of users.
     * Also creates an empty diary for the user.
     * for the user.
     * @param userExists
     * @param users
     * @param diaries
     * @param user
     * @throws IOException
     */
    public static void createUser(Boolean userExists, List<User> users, List<Diary> diaries, String user) throws IOException {
        if (!userExists) {
            User newUser = new User(user);
            users.add(newUser);
            JsonUtils.gsonWriteUserToFile(users);
            Diary newUserDiary = new Diary(newUser);
            diaries.add(newUserDiary);
            JsonUtils.gsonWriteDiaryToFile(diaries);
        }
    }
}
