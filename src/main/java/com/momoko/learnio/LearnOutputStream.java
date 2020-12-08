package com.momoko.learnio;

/**
 * Created by momoko on 2019/11/26
 *
 * @author momoko
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * write() 方法只会写入一个字节，只写入int最低8位表示字节部分
 */
public class LearnOutputStream  {
    public static void main(String[] args) throws IOException {
        writeFile("out/readme.txt");

    }
    public static void writeFile(String fileName) throws IOException {
        OutputStream output = new FileOutputStream(fileName);
        output.write(72); // H
        output.write(101); // e
        output.write(108); // l
        output.write(108); // l
        output.write(111); // o
        output.close();

//        try (OutputStream output = new FileOutputStream("out/readme.txt")) {
//            output.write("Hello".getBytes("UTF-8")); // Hello
//        } // 编译器在此自动为我们写入finally并调用close()

    }

}
