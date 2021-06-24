package sk.cybersoft.cybernotes.cybernotesapplication.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class FileUtility {
    public static void saveToFile(String text, String filename) throws IOException {
        File directory = new File(Info.getNotesPath());
        if(!directory.exists()) {
            directory.mkdirs();
        }

        FileOutputStream outputStream = new FileOutputStream(Info.getNotesPath() + "\\" + filename + ".txt");
        byte[] strToBytes = text.getBytes();
        outputStream.write(strToBytes);

        outputStream.close();
    }
}
