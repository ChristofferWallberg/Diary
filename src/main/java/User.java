public class User {
    private String username;
    private static String currentUserName;
    private static User currentUser;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void setCurrentUser(User currentUser) {
        User.currentUser = currentUser;
    }

    public static String getCurrentUserName() {
        return currentUserName;
    }

    public static void setCurrentUserName(String currentUserName) {
        User.currentUserName = currentUserName;
    }

    @Override
    public String toString() {
        return username;
    }
}
