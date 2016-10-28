package com.company;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Simplest FileWorker implementation
 */
public final class FileWorker {

    private FileWorker() {
    }

    /**
     *
     * @param fileName input file name
     * @return  String
     * @throws FileNotFoundException throws
     */
    public static String read(final String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            File file = new File(fileName);
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    //sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    /**
     *
     * @param textFromFile formatted text
     * @throws FileNotFoundException throws
     */
    public static void formatter(final String textFromFile) throws FileNotFoundException {

        final int fourSpace = 4;

        File file = new File("output");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            String space = "";
            boolean check = false;
            for (int i = 0; i < textFromFile.length(); i++) {
                String symbol = textFromFile.substring(i, i + 1);
                if (symbol.equals(";")) {
                    check = true;
                    out.println(symbol);
                    //out.print(space);
                } else {
                if (symbol.equals("{")) {
                    if (textFromFile.substring(i - 1, i).equals(" ")) {
                        space = space + "    ";
                        out.println(symbol);
                        out.print(space);
                    } else {
                        space = space + "    ";
                        out.print(" ");
                        out.println(symbol);
                        out.print(space);
                    }
                } else {
                    if (symbol.equals("}")) {
                        if (check) {
                            space = space.substring(0, space.length() - fourSpace);
                            out.print(space);
                            out.print(symbol);
                            check = false;
                        } else {
                            space = space.substring(0, space.length() - fourSpace);
                            out.println("");
                            out.print(space);
                            out.print(symbol);
                        }
                    } else {
                        if (check && !symbol.equals(" ")) {
                            check = false;
                            out.print(space);
                            out.print(symbol);
                        } else {
                            if (check && symbol.equals(" ")) {
                                continue;
                            } else {
                                out.print(symbol);
                            }
                        }
                    }
                }
            }
        }
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void exists(final String fileName) throws FileNotFoundException {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException(file.getName());
            }
    }

}
