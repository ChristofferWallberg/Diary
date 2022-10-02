import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    private String currentUser;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return username;
    }
}
