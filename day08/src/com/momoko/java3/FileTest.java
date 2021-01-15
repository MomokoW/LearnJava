package com.momoko.java3;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by momoko on 2021/1/14.
 */
public class FileTest {

    @Test
    public void test1() throws IOException {
        File file = new File("day08.iml");
        file.getParent();
    }

    @Test
    public void test2() throws IOException {
        File file = new File("hello.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(file);
            fw.write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
}