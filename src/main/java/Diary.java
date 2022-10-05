import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
    /**
     *<p>
     *     Method used to print all diary entries for a certain diary.
     *</p>
     *Can be used as :
     *<p>
     *     diary.printDiaryEntries()
     *</p>
    **/
    public void printDiaryEntries() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (DiaryEntry diaryEntry : diary) {
            System.out.println("Användare: " + diaryEntry.getUser());
            System.out.println("Titel av inlägg: " + diaryEntry.getTitle());
            System.out.println("Inläggets text: " + diaryEntry.getText());
            System.out.println("Datum och tid när inlägget skapades: " + diaryEntry.getLocalDateTime().format(formatter));
        }
    }
}
