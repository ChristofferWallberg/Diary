package model;

import util.JsonUtils;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Diary {
    private User user;
    private final List<DiaryEntry> DIARY;

    public Diary(User user) {
        this.user = user;
        this.DIARY = new ArrayList<>();
    }

    /**
     * Create and save new model.Diary Entry to JSON in the current users diary.
     * @param diaries
     * @param scannerTitle
     * @param scannerText
     * @return
     * @throws IOException
     */
    public static DiaryEntry createNewDiaryEntry(List<Diary> diaries, String scannerTitle, String scannerText) throws IOException {
        DiaryEntry diaryEntry = new DiaryEntry(User.getCURRENTUSER(), scannerTitle, scannerText);
        for (Diary diary : diaries) {
            if (Objects.equals(User.getCURRENTUSER().getUsername(), diary.getUser().getUsername())) {
                diary.getDiary().add(diaryEntry);
                JsonUtils.gsonWriteDiaryToFile(diaries);
            }
        }
        return diaryEntry;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DiaryEntry> getDiary() {
        return DIARY;
    }
    /**
     * <p>
     * Method used to print all diary entries for a certain diary.
     * </p>
     * Can be used as :
     * <p>
     * diary.printDiaryEntries()
     * </p>
     **/
    public void printDiaryEntries() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int i = 1;
        for (DiaryEntry diaryEntry : DIARY) {
            System.out.println("Inlägg #" + i + ": ");
            System.out.println("\tAnvändare: " + diaryEntry.getUSER());
            System.out.println("\tTitel av inlägg: " + diaryEntry.getTITLE());
            System.out.println("\tInläggets text: " + diaryEntry.getTEXT());
            System.out.println("\tDatum och tid när inlägget skapades: " + diaryEntry.getLocalDateTime().format(formatter) +
                    "\n----------------------------------------------");
            i++;
        }
    }
    /**
     * Print the diary entries for the user currently logged in.
     * @param diary
     */
    public void printDiaryEntriesCurrentUser(Diary diary) {
        if (Objects.equals(User.getCURRENTUSER().getUsername(), diary.getUser().getUsername())
                && !(diary.getDiary().isEmpty())) {
                diary.printDiaryEntries();
        } else if (diary.getDiary().isEmpty()
                && diary.getUser().getUsername().equalsIgnoreCase(User.getCURRENTUSER().getUsername())) {
            System.out.println("Du har inga inlägg! Skriv några inlägg vettja!");
        }
    }
}
