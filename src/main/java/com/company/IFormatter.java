package com.company;

import java.io.FileNotFoundException;

/**
 * interface Formatter.
 */
public interface IFormatter {
    /**
     *
     * @param textFromFile text from file
     * @param fileNameOut out file name
     * @throws FileNotFoundException throws
     */
    void formatter(String textFromFile, String fileNameOut) throws FileNotFoundException;
}
