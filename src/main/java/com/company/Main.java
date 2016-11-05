package com.company;

import java.io.FileNotFoundException;

/**
 * Simplest Main implementation
 */
public final class Main {
    /**
     * constructor
     */
    private Main() {
    }
    private static String fileName = "./input";
    private static String fileNameOut = "./output";

    /**
     * Entry method
     * @param args command line args, ignored
     */
    public static void main(final String[] args) {
        try {
            FileWorker reader = new FileWorker();
            FileWorker format = new FileWorker();
            String textFromFile = reader.read(fileName);
            format.formatter(textFromFile, fileNameOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
