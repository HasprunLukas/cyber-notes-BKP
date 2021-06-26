package sk.cybersoft.cybernotes.cybernotesapplication.utility;

import sk.cybersoft.cybernotes.cybernotesapplication.entity.Note;
import sk.cybersoft.cybernotes.cybernotesapplication.entity.User;

public abstract class Info {
    private static String newNoteName;
    private static final String notesPath = System.getProperty("user.home") + "\\Documents\\CyberSoft\\CyberNotes";
    private static final String databaseUrl = "http://localhost:8080";
    private static Note note;
    private static User user;

    public static String getNewNoteName() {
        return newNoteName;
    }

    public static void setNewNoteName(String newNoteName) {
        Info.newNoteName = newNoteName;

    }

    public static String getNotesPath() {
        return notesPath;
    }

    public static String getDatabaseUrl() {
        return databaseUrl;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Info.user = user;
    }

    public static Note getNote() {
        return note;
    }

    public static void setNote(Note note) {
        Info.note = note;
    }
}
