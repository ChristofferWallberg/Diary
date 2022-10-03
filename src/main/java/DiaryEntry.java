import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiaryEntry {
    private User user;
    private String title;
    private String text;
    private Date dateStamp;
    private List<DiaryEntry> diaryEntries = new ArrayList<>();

    public DiaryEntry(User user, String title, String text) {
        this.user = user;
        this.title = title;
        this.text = text;
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        dateStamp = new Date();
    }

    public DiaryEntry(List<DiaryEntry> diaryEntries) {
        this.diaryEntries = diaryEntries;
    }

    public List<DiaryEntry> getDiaryEntries() {
        return diaryEntries;
    }

    public void setDiaryEntries(List<DiaryEntry> diaryEntries) {
        this.diaryEntries = diaryEntries;
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
