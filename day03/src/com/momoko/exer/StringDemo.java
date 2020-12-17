package com.momoko.exer;

/**
 * Created by momoko on 2020/12/16.
 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为“abfedcg”
 */
public class StringDemo {
    public static void main(String[] args) {
        String str = "abcdefg";

        System.out.println(reverse(str, 2, 5));
    }

    public static String reverse(String str, int startIndex, int endIndex) {

        StringBuilder sb1 = new StringBuilder(str );
        String s1 = sb1.substring(startIndex, endIndex + 1);
        StringBuilder sb2 = new StringBuilder(s1).reverse();
        StringBuilder sb3 = sb1.replace(startIndex, endIndex, sb2.toString());
        return sb3.toString();
    }


}