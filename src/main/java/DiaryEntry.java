import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DiaryEntry {
    private User username;
    private String title;
    private String text;
    private Date dateStamp;

    public DiaryEntry(User username, String title, String text) {
        this.username = username;
        this.title = title;
        this.text = text;
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateStamp = new Date();
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(Date dateStamp) {
        this.dateStamp = dateStamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
