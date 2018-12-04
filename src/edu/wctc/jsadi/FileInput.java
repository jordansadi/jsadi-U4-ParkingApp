package edu.wctc.jsadi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class creates a framework for inputting text from a file into the program.
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 1203 4
 */
public class FileInput {

    private static FileInput inst = null;
    private BufferedReader in = null;
    private String fileName;

    /**
     * This constructor creates an instance of the FileInput class using a specified file
     * The constructor is private because this class uses a singleton pattern
     * @param fileName the name of the desired file
     */
    private FileInput(String fileName) {
        this.fileName = fileName;
        try {
            in = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " " + e);
        }
    }

    /**
     * This method creates an instance of the FileInput class if one has not already been instantiated
     * @param fileName the name of the desired file
     * @return FileInput an instance of the FileInput class
     */
    static FileInput getFileInput(String fileName) {
        if (inst == null)
            inst = new FileInput(fileName);
        return inst;
    }

    /**
     * This method attempts to read the entire file, one line at a time
     */
    public void fileRead() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
        }
    }

    /**
     * This method attempts to read the next line of the specified file
     * @return String of the next line in the file
     */
    public String fileReadLine() {
        try {
            String line = in.readLine();
            return line;
        } catch (Exception e) {
            System.out.println("File Write Error: " + fileName + " " + e);
            return null;
        }
    }

    /**
     * This method attempts to close the specified file
     */
    public void fileClose() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}