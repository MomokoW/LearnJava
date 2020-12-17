package com.momoko.java;

import org.junit.Test;

/**
 * Created by momoko on 2020/12/16.
 */
public class StringTest {

    @Test
    public void testString() {
        System.out.println("run");
        String s1 = "123";
        System.out.println(s1.charAt(0));
        System.out.println(toString().repeat(5));
        System.out.println(Integer.parseInt(s1));

    }

    @Test
    public void test3() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s5 == s6);
        System.out.println(s5 == s6);
    }

    @Test
    public void test4() {
        String str1 = "abcdef";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

}