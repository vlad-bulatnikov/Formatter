package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static String text = "This new text \nThis new text2\nThis new text3\nThis new text4\n";
    private static String fileName = "./input";


    public static void main(String[] args) {
        try {
            String textFromFile = FileWorker.read(fileName);
            FileWorker.formatter(textFromFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
