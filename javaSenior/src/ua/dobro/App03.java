package ua.dobro;

import java.io.*;

public class App03 {

    public static void main(String[] args) {
        FileManager.makeCopy("first.txt");
    }
}

class FileManager {
    public FileManager() {
    }

    public static void makeCopy(String fisFile) {
        try {
            FileInputStream fis = new FileInputStream(fisFile);
            FileOutputStream fos = new FileOutputStream("second.txt");
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }

            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            System.err.println("FileManager: " + e);
        } catch (IOException e) {
            System.err.println("FileManager: " + e);
        }
    }
}
