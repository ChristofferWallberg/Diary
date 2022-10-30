package model;

import java.time.LocalDateTime;

public class DiaryEntry {
    private final User USER;
    private final String TITLE;
    private final String TEXT;
    private final LocalDateTime LOCALDATETIME;

    public DiaryEntry(User USER, String TITLE, String TEXT) {
        this.USER = USER;
        this.TITLE = TITLE;
        this.TEXT = TEXT;
        this.LOCALDATETIME = LocalDateTime.now();
    }

    public User getUSER() {
        return USER;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getTEXT() {
        return TEXT;
    }

    public LocalDateTime getLocalDateTime() {
        return LOCALDATETIME;
    }
}
