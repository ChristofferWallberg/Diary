import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Diary {
    private User user;
    private List<DiaryEntry> diary;

    public Diary(User user) {
        this.user = user;
        this.diary = new ArrayList<>();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DiaryEntry> getDiary() {
        return diary;
    }

    public void setDiary(List<DiaryEntry> diary) {
        this.diary = diary;
    }
    public void printDiaryEntries() {
        for (DiaryEntry diaryEntry : diary) {
            System.out.println("Användare: " + diaryEntry.getUser());
            System.out.println("Titel av inlägg: " + diaryEntry.getTitle());
            System.out.println("Inläggets text: " + diaryEntry.getText());
            System.out.println("Datum och tid när inlägget skapades: " + diaryEntry.getDateTimeStamp());
        }
    }
}
