package com.company;

import java.io.FileNotFoundException;

/**
 * interface read.
 */
public interface IReader {
    /**
     *
     * @param fileName input file
     * @return text from file
     * @throws FileNotFoundException throws
     */
    String read(String fileName) throws FileNotFoundException;
}
