package com.company;

import java.io.*;

/**
 * Created by vladislav on 19.10.16.
 */
public class FileWorker {

    public static String read(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        exists(fileName);
        try {
            File file = new File(fileName);;
            BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void formatter(String textFromFile) throws FileNotFoundException {

        File file = new File("output");

        try {
            if(!file.exists()){
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
                }else {
                if (symbol.equals("{")) {
                    if(textFromFile.substring(i-1, i).equals(" ")) {
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
                            space = space.substring(0, space.length() - 4);
                            out.print(space);
                            out.print(symbol);
                            check=false;
                        } else {
                            space = space.substring(0, space.length() - 4);
                            out.println("");
                            out.print(space);
                            out.print(symbol);
                        }
                    } else {
                        if(check && !symbol.equals(" ")) {
                            check=false;
                            out.print(space);
                            out.print(symbol);
                        } else {
                            if (check && symbol.equals(" ")) {
                                continue;
                            }else {
                                out.print(symbol);
                            }
                        }

                    }
                }
            }
        }
            out.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void exists(String fileName) throws FileNotFoundException {
            File file = new File(fileName);
            if (!file.exists()){
                throw new FileNotFoundException(file.getName());
            }
    }

}
