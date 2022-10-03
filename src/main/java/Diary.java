import java.util.ArrayList;
import java.util.List;

public class Diary {
    private User user;
    private List<DiaryEntry> diary = new ArrayList<>();
    private List<Diary> diaries = new ArrayList<>();

    public Diary(User user, List<DiaryEntry> diary) {
        this.user = user;
        this.diary = diary;
    }

    public Diary(List<Diary> diaries) {
        this.diaries = diaries;
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

    public List<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(List<Diary> diaries) {
        this.diaries = diaries;
    }
}
