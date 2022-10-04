import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class DiaryEntry {
    private User user;
    private String title;
    private String text;
    private Date dateTimeStamp;
    private List<DiaryEntry> diaryEntries = new ArrayList<>();

    public DiaryEntry(User user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
        Date date = new Date();
        dateTimeStamp = Calendar.getInstance().getTime();
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

    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }
}
