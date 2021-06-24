package sk.cybersoft.cybernotes.cybernotesapplication.utility;

public abstract class Info {
    private static String newNoteName;
    private static final String notesPath = System.getProperty("user.home") + "\\Documents\\CyberSoft\\CyberNotes";
    private static final String databaseUrl = "http://localhost:8080";

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
}
