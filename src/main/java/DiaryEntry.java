import java.time.LocalDateTime;


public class DiaryEntry {
    private User user;
    private String title;
    private String text;
    private LocalDateTime localDateTime;

    public DiaryEntry(User user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
        this.localDateTime = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
