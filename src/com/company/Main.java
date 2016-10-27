package com.company;

import java.io.FileNotFoundException;

/**
 * Simplest Main implementation
 */
public final class Main {

    private Main() {
    }
    private static String fileName = "./input";

    /**
     * Entry method
     * @param args command line args, ignored
     */
    public static void main(final String[] args) {
        try {
            String textFromFile = FileWorker.read(fileName);
            FileWorker.formatter(textFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
