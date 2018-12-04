package edu.wctc.jsadi;

import java.io.*;

/**
 * This class creates a framework for writing to a specified file
 * Created by mgreen14 on 12/27/17.
 * @author Matt Green
 * @version 2018 1203 4
 */
public class FileOutput {

    private static FileOutput inst = null;
    private Writer out = null;
    private String fileName;

    /**
     * This constructor creates an instance of the FileOutput class
     * The constructor is private because this classes uses a singleton pattern
     * @param fileName the name of the specified file
     */
    private FileOutput(String fileName) {
        this.fileName = fileName;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " "  + e);
        }
    }

    /**
     * This method creates an instance of the FileOutput class if one has not already been instantiated
     * @param fileName the name of the desired file
     * @return FileOutput an instance of the FileOutput class
     */
    static FileOutput getFileOutput(String fileName) {
        if (inst == null)
            inst = new FileOutput(fileName);
        return inst;
    }

    /**
     * This method attempts to write a line to the specified file
     * @param line the line that is meant to be written to the file
     */
    public void fileWrite(String line) {
        try {
            out.write(line+"\n");
        }
        catch(Exception e) {
            System.out.println("File Write Error: " + fileName + " "  + e);
        }
    }

    /**
     * This method attempts to close the specified file
     */
    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}