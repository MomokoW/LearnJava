package com.momoko.learnio;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by momoko on 2019/12/3
 *
 * @author momoko
 */
public class LearnPrintWriter {
    public static void main(String[] args) {
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)){
            pw.println("Hello");
            pw.println(12345);
            pw.println(true);
        }
        System.out.println(buffer.toString());
    }
}
