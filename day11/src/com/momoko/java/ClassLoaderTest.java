package com.momoko.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by momoko on 2021/1/19.
 */
public class ClassLoaderTest {

    @Test
    public void test1() throws Exception {
        Properties pros = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);

        String user = pros.getProperty("user");
        System.out.println(user);


        //这种方式的文件路径在src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);




    }
}