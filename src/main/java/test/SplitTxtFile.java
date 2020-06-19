package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by momoko on 2020/4/6.
 */
public class SplitTxtFile {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
    public static void main(String[] args) {

        int a = 72;
        int b = 105;
        int c = 65281;
        // FIXME:
        String s1 = "" + (char)a + (char)b + (char)c;
        System.out.println(s1);

        String fruit = "apple";
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear","mango" ->2;
            default -> 0;
        };
        System.out.println(opt);

    }

}