import java.util.Date;

public class DiaryEntries {
    private User user;
    private String title;
    private Date date;

    public DiaryEntries(User user, String title, Date date) {
        this.user = user;
        this.title = title;
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
