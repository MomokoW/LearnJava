package com.momoko.java;

import org.junit.Test;

/**
 * Created by momoko on 2020/12/16.
 */
public class StringBufferBuilderTest {
    @Test
    public void test1() {
        StringBuffer sb2 = new StringBuffer("abc");
        sb2.append(1);
        char[] hello = new char[] {'H','E','L','L','O'};
        StringBuffer sb1 = new StringBuffer(String.valueOf(hello));
        StringBuffer sb3 = sb1.reverse();
        System.out.println(sb3.toString());

    }

}