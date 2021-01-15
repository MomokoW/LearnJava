package com.momoko.java3;

import com.momoko.exer.User;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

    @Test
    public void test3(){

        //序列化
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("user.txt"));
            oos.writeObject(new User(2, 34, "Lily"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test4() {
        //反序列化
        ObjectInputStream ois= null;

        try {
            ois = new ObjectInputStream(new FileInputStream("hello.txt"));
            Object obj = ois.readObject();
            String str = (String) obj;
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}