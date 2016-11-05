package com.company;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * Test for class FileWorker.
 */
public class FileWorkerTest {
    private IFormatter formatter;
    
    @Before
    public void setUp() {

        formatter = new FileWorker();
    }
    @Test
    public void testRider() throws FileNotFoundException {
        IReader in = new FileWorker();
        String text = in.read("./inputTest");
        assertEquals("wqeqe{eqwe();}\n", text);
    }

    @Test
    public void testFormater() throws FileNotFoundException {
        IFormatter out = new FileWorker();
        IReader in = new FileWorker();
        out.formatter("formatter() {int c; for(){int a;} }","outputTest");
        String text = in.read("outputTest");
        assertEquals("formatter() {\n" +
                "    int c;\n" +
                "    for() {\n" +
                "        int a;\n" +
                "    } \n" +
                "}\n",text);
    }
}
